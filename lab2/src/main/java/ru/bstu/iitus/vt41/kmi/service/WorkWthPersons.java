package ru.bstu.iitus.vt41.kmi.service;

import ru.bstu.iitus.vt41.kmi.enums.PersonType;
import ru.bstu.iitus.vt41.kmi.person.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkWthPersons {
    public WorkWthPersons() { }
    public ArrayList<Person> inputPersons(Scanner scanner){
        System.out.print("Введите количество человек: ");
        int count = scanner.nextInt();
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < count; i++){
            list.add(inputPerson(scanner));
        }
        return list;
    }
    public Person inputPerson(Scanner scanner){
        Person person;

        String label = getLabelPersonTypeInformation();
        int mode = InputPerson.inputInteger(scanner, label);
        boolean flag;
        do{
            person = makePersonByIndex(scanner, mode);
            flag = person == null;
        } while (flag);
        return person;
    }
    private Person makePersonByIndex(Scanner scanner, int mode) {
        PersonType personType = PersonType.valueOfID(mode);
        System.out.println("Введите персону с типом '" + personType.getLabel() + "'");
        try {
            Person currentPerson = personType.getPersonClass().newInstance();
            currentPerson.init(scanner);
            return currentPerson;
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("Введён неверный номер! Повторите ввод:  " + personType.getPersonClass().getSimpleName());
            return null;
        }
    }
    private String getLabelPersonTypeInformation() {
        String label = "Укажите тип вводимой записи:";
        for (PersonType type : PersonType.values()) {
            label = label + "\n" + type.getId() + ". " + type.getLabel();
        }
        return label;
    }
    public static Person getJunior(ArrayList<Person> persons){
        int maxAge = Integer.MAX_VALUE;
        Person juniorPerson = null;
        for (Person p : persons){
            int currentAge = p.getAge();
            if (currentAge < maxAge) {
                maxAge = currentAge;
                juniorPerson = p;
            }
        }
        return juniorPerson;
    }
}
