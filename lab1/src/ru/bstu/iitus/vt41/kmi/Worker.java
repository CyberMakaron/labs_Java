package ru.bstu.iitus.vt41.kmi;

import java.util.Scanner;

public class Worker extends Person{
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
