package ru.bstu.iitus.vt41.kmi;

// Варивант №3

import ru.bstu.iitus.vt41.kmi.person.Person;
import ru.bstu.iitus.vt41.kmi.service.WorkWthPersons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkWthPersons work = new WorkWthPersons();
        ArrayList<Person> persons = new ArrayList<>();
        try {
            persons.addAll(work.loadPersonsFromFile());
        } catch (Exception e){
            System.out.println("Error (loadPersonsFromFle): " + e);
        }
        persons.addAll(work.inputPersons(scanner));
        String junior = "Младший человек: " + work.getJunior(persons);
        outputIntoConsole(persons, junior);
        outputIntoFile(persons, junior);
    }
    private static void outputIntoConsole(ArrayList<Person> persons, String junior){
        System.out.println("Введённые записи:");
        for (Person p : persons){
            System.out.println(p);
        }
        System.out.println("\n" + junior);
    }
    private static void outputIntoFile(ArrayList<Person> persons, String junior){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(WorkWthPersons.getPathOutput(), true));
            writer.append("\n" + LocalDate.now() + ":");
            for (Person p : persons){
                writer.append("\n" + p.toString());
            }
            writer.append("\n" + junior + "\n");
        } catch (IOException ex){
            System.out.println("Error (out to file):" + ex);
        } finally {
            try {
                writer.close();
            } catch(IOException ex){ }
        }
    }
}
