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