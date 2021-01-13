package ru.bstu.iitus.vt41.kmi.person;

import lombok.*;
import java.util.Calendar;
import java.util.Scanner;

@ToString
public abstract class Person {
    @ToString.Exclude
    Calendar birthday;
    @ToString.Include(name = "Имя")
    String name;
    public abstract void init(Scanner scanner); // считывание параметров с консоли
    @ToString.Include(name = "Возраст")
    public int getAge(){ // возвращается возраст человека на текущий момент (полное количество лет)
        Calendar currentDate = Calendar.getInstance();
        int years = currentDate.get(Calendar.YEAR) - this.birthday.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH);
        int birthMonth = this.birthday.get(Calendar.MONTH);
        if (currentMonth < birthMonth) {
            years --;
        } else if (currentMonth == birthMonth
                && currentDate.get(Calendar.DAY_OF_MONTH) < this.birthday.get(Calendar.DAY_OF_MONTH)) {
            years --;
        }
        return years;
    }
}