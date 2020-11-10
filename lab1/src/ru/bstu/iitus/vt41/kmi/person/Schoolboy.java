package ru.bstu.iitus.vt41.kmi.person;

import ru.bstu.iitus.vt41.kmi.service.InputPerson;

import java.util.Scanner;

public class Schoolboy extends Person {
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
