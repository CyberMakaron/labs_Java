package ru.bstu.iitus.vt41.kmi.service;

import lombok.Getter;
import ru.bstu.iitus.vt41.kmi.person.Person;
import java.util.ArrayList;

public class AsyncFileInput implements Runnable{
    @Getter
    ArrayList<Person> persons;
    public AsyncFileInput(){
        persons = new ArrayList<>();
    }
    @Override
    public void run() {
        WorkWthPersons work = new WorkWthPersons();
        try {
            this.persons.addAll(work.loadPersonsFromFile());
        } catch (Exception e){
            System.out.println("Error (loadPersonsFromFle): " + e);
        }
    }
}
