package ru.bstu.iitus.vt41.kmi;

// Варивант №3

import ru.bstu.iitus.vt41.kmi.person.Person;
import ru.bstu.iitus.vt41.kmi.person.Worker;
import ru.bstu.iitus.vt41.kmi.service.WorkWthPersons;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> persons = null;
        WorkWthPersons work = new WorkWthPersons();
        persons = work.inputPersons(scanner);

        System.out.println("Введённые записи:");
        for (Person p : persons){
            System.out.println(p);
        }

        System.out.println("\nМладший человек: " + WorkWthPersons.getJunior(persons));
    }
}
