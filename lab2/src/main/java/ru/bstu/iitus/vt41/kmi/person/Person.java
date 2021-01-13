package ru.bstu.iitus.vt41.kmi.person;

import lombok.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

@ToString
public abstract class Person {
    @ToString.Exclude
    LocalDate birthday;
    @ToString.Include(name = "Имя")
    String name;
    public abstract void init(Scanner scanner); // считывание параметров с консоли
    @ToString.Include(name = "Возраст")
    public int getAge(){ // возвращается возраст человека на текущий момент (полное количество лет)
        LocalDate currentDate = LocalDate.now();
        int years = currentDate.getYear() - this.birthday.getYear();
        int currentMonth = currentDate.getMonthValue();
        int birthMonth = this.birthday.getMonthValue();
        if (currentMonth < birthMonth) {
            years --;
        } else if (currentMonth == birthMonth
                && currentDate.getDayOfMonth() < this.birthday.getDayOfMonth()) {
            years --;
        }
        return years;
    }
}