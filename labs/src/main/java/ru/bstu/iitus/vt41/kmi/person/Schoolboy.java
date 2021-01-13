package ru.bstu.iitus.vt41.kmi.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONObject;
import ru.bstu.iitus.vt41.kmi.service.InputPerson;
import java.util.Scanner;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true)
public class Schoolboy extends Person {
    @ToString.Include(name = "Класс")
    String _class;
    @ToString.Include(name = "Школа")
    String school;
    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о школьнике:");
        super.name = InputPerson.inputString(scanner, "Имя школьника:");
        this._class = InputPerson.inputString(scanner, "Класс:");
        this.school = InputPerson.inputString(scanner, "Школа:");
        super.birthday = InputPerson.inputDate(scanner, "Дата рождения:");
    }
    public void initFromJSON(JSONObject jsonObject){
        super.name = (String)jsonObject.get("Имя");
        this._class = (String)jsonObject.get("Класс");
        this.school = (String)jsonObject.get("Школа");
        String stringBirthday = (String)jsonObject.get("Дата рождения");
        super.birthday =  InputPerson.getLocalDate(stringBirthday);
    }

}
