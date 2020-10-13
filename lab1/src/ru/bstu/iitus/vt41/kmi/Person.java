package ru.bstu.iitus.vt41.kmi;

import java.util.Calendar;
import java.util.Scanner;

abstract class Person {
    Calendar b_day;
    String name;
    public abstract void init(Scanner scanner); // считывание параметров с консоли

    public int getAge(){ // возвращается возраст человека на текущий момент (полное количество лет)
        Calendar current_date = Calendar.getInstance();
        int years = current_date.get(Calendar.YEAR) - this.b_day.get(Calendar.YEAR);
        int current_month = current_date.get(Calendar.MONTH);
        int birth_month = this.b_day.get(Calendar.MONTH);
        if (current_month < birth_month) {
            years --;
        } else if (current_month == birth_month
                && current_date.get(Calendar.DAY_OF_MONTH) < this.b_day.get(Calendar.DAY_OF_MONTH)) {
            years --;
        }
        return years;
    }
}

class Student extends Person{
    String group;
    String institute;
    String credit_cadr_num;

    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о студенте:");
        this.name = InputPerson.inputString(scanner, "Имя студента:");
        this.group = InputPerson.inputString(scanner, "Группа:");
        this.institute = InputPerson.inputString(scanner, "Институт:");
        this.credit_cadr_num = InputPerson.inputString(scanner, "Номер зачётки:");
        this.b_day = InputPerson.inputDate(scanner, "Дата рождения:");
    }

    @Override
    public String toString(){
        return String.format("Студент %s группы %s, институт - %s, номер зачётки - %s, возраст - %d",
                this.name, this.group, this.institute, this.credit_cadr_num, getAge());
    }
}

class Schoolboy extends Person{
    String _class;
    String school;

    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о школьнике:");
        this.name = InputPerson.inputString(scanner, "Имя школьника:");
        this._class = InputPerson.inputString(scanner, "Класс:");
        this.school = InputPerson.inputString(scanner, "Школа:");
        this.b_day = InputPerson.inputDate(scanner, "Дата рождения:");
    }

    @Override
    public String toString(){
        return String.format("Ученик %s %s класса, школа - %s, возраст - %d",
                this.name, this._class, this.school, getAge());
    }
}

class Worker extends Person{
    String organization;
    String tab_num;
    // хорошо бы добавить должность, но тогда не вяжется toString в наследуемых классах - придётся переопределять полностью

    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о сотруднике:");
        this.name = InputPerson.inputString(scanner, "Имя сотрудника:");
        this.organization = InputPerson.inputString(scanner, "Наименование организации:");
        this.tab_num = InputPerson.inputString(scanner, "Табельный номер:");
        this.b_day = InputPerson.inputDate(scanner, "Дата рождения:");
    }

    @Override
    public String toString(){
        return String.format("Сотрудник организации \"%s\", %s, табельный номер - %s, возраст - %d",
                this.organization, this.name, this.tab_num, getAge());
    }
}

class Teacher extends Worker{   // не самый удачный вариант - наследовать от моей реализации работника, но для лабы сойдёт
    String subject;
    String certificate_num;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.subject = InputPerson.inputString(scanner, "Преподаваемый предмет:");
        this.certificate_num = InputPerson.inputString(scanner, "Номер сертификата:");
    }

    @Override
    public String toString(){
        return String.format("Преподаватель. " + super.toString() + ", преподаваемый предмет - %s, номер сертификата - %s", this.subject, this.certificate_num);
    }
}

class Director extends Worker{
    String post;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.post = InputPerson.inputString(scanner, "Директор какой масти:");
    }

    @Override
    public String toString(){
        return String.format("%s. " + super.toString(), this.post);
    }
}