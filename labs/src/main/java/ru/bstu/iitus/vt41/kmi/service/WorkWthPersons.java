package ru.bstu.iitus.vt41.kmi.service;

import java.lang.String;
import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.bstu.iitus.vt41.kmi.enums.PersonType;
import ru.bstu.iitus.vt41.kmi.person.Person;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWthPersons {
    @Getter
    final static String pathInput = "./src/inputPersons.json";
    @Getter
    final static String pathOutput = "./src/outputPersons.txt";
    public WorkWthPersons() { }
    public ArrayList<Person> inputPersons(Scanner scanner){
        System.out.print("Введите количество человек: ");
        int count = scanner.nextInt();
        ArrayList<Person> list = new ArrayList<>();
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
        PersonType personType = null;
        try {
            personType = PersonType.valueOfID(mode);
            System.out.println("Введите персону с типом '" + personType.getLabel() + "'");
            Person currentPerson = personType.getPersonClass().newInstance();
            currentPerson.init(scanner);
            return currentPerson;
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("Введён неверный номер! Повторите ввод:  " + personType.getPersonClass().getSimpleName());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Введён неверный номер! Повторите ввод");
            return null;
        }
    }
    private String getLabelPersonTypeInformation() {
        StringBuilder label = new StringBuilder("Укажите тип вводимой записи:");
        for (PersonType type : PersonType.values()) {
            label.append("\n").append(type.getId()).append(". ").append(type.getLabel());
        }
        return label.toString();
    }
    public Person getJunior(ArrayList<Person> persons){
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

    public ArrayList<Person> loadPersonsFromFile() throws InstantiationException, IllegalAccessException {
        FileReader reader;
        try {
            reader = new FileReader(getPathInput());
        } catch(IOException e){
            System.out.println("Load from file failed: " + e);
            return null;
        }
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (ParseException | IOException ex){
            System.out.println("Error during parsing: " + ex);
            return null;
        }
        JSONArray jsonPersons = (JSONArray) jsonObject.get("Persons");
        ArrayList<Person> persons = new ArrayList<>();
        for (Object jsonPerson : jsonPersons) {
            Person p = makePersonFromJSON((JSONObject) jsonPerson);
            if (p != null)
                persons.add(p);
        }
        return persons;
    }
    private Person makePersonFromJSON(JSONObject jsonPerson) throws IllegalAccessException, InstantiationException {
        String label = (String) jsonPerson.get("label");
        Person person;
        try {
            person = PersonType.valueOfLabel(label).getPersonClass().newInstance();
        } catch(IllegalArgumentException ex){
            return null;
        }
        person.initFromJSON(jsonPerson);
        return person;
    }
}
