package ru.bstu.iitus.vt41.kmi;

import java.util.Scanner;

public abstract class Person {
    public abstract void init(Scanner scanner); // считывание параметров с консоли

    public int getAge(){ // возвращается возраст человека на текущий момент (полное количество лет)
        return 0;
    }

    public String toString(); // возвращается состояние объекта в виде строки
}
