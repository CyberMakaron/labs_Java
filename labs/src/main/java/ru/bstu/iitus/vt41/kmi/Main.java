package ru.bstu.iitus.vt41.kmi;

// Варивант №3

import ru.bstu.iitus.vt41.kmi.person.Person;
import ru.bstu.iitus.vt41.kmi.service.AsyncFileInput;
import ru.bstu.iitus.vt41.kmi.service.AsyncFileOutput;
import ru.bstu.iitus.vt41.kmi.service.WorkWthPersons;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkWthPersons work = new WorkWthPersons();
        ArrayList<Person> persons = new ArrayList<>();

        AsyncFileInput asyncFileInput = new AsyncFileInput();
        Thread thread = new Thread(asyncFileInput);
        thread.start();
        persons.addAll(work.inputPersons(scanner));
        if (thread.isAlive()) {
            System.out.println("Дождитесь завершения потока чтения из файла.");
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println("Interrupt exception: " + ex);
            }
        }
        persons.addAll(asyncFileInput.getPersons());

        String junior = "Младший человек: " + work.getJunior(persons);
        outputIntoConsole(persons, junior);
        AsyncFileOutput asyncFileOutput = new AsyncFileOutput(persons, junior);
        new Thread(asyncFileOutput).start();
    }
    private static void outputIntoConsole(ArrayList<Person> persons, String junior){
        System.out.println("Введённые записи:");
        persons.forEach(System.out::println);
        System.out.println("\n" + junior);
    }
}
