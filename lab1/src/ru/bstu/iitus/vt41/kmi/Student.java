package ru.bstu.iitus.vt41.kmi;

import java.util.Scanner;

public class Student extends Person{
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