package ru.bstu.iitus.vt41.kmi.service;

import java.lang.String;
import ru.bstu.iitus.vt41.kmi.person.Person;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AsyncFileOutput implements Runnable{
    ArrayList<Person> persons;
    String junior;
    public AsyncFileOutput(ArrayList<Person> persons, String junior){
        this.persons = persons;
        this.junior = junior;
    }
    @Override
    public void run() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(WorkWthPersons.getPathOutput(), true));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.append("\n" + LocalDateTime.now().format(formatter) + ":");
            for (Person p : persons){
                writer.append("\n" + p.toString());
            }
            writer.append("\n" + junior + "\n");
        } catch (IOException ex){
            System.out.println("Error (out to file):" + ex);
        } finally {
            try {
                writer.close();
            } catch(IOException ex){
                System.out.println("Error during close writer:" + ex);
            }
        }
    }
}
