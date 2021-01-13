package ru.bstu.iitus.vt41.kmi.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.bstu.iitus.vt41.kmi.Exeptions.OnlyDigitException;
import ru.bstu.iitus.vt41.kmi.service.InputPerson;

import java.util.Scanner;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true)
public class Worker extends Person {
    @ToString.Include(name = "Организация")
    String organization;
    @ToString.Include(name = "Табельный номер")
    String tabNum;
    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о сотруднике:");
        super.name = InputPerson.inputString(scanner, "Имя сотрудника:");
        this.organization = InputPerson.inputString(scanner, "Наименование организации:");
        this.tabNum = "";
        String msg = "Табельный номер:";
        while (this.tabNum.equals(""))
        try {
            this.tabNum = InputPerson.inputDigitString(scanner, msg);
        }
        catch (OnlyDigitException ex) {
            msg = "Табельный номер должен содержать только цифры!\n" + msg;
        }
        super.birthday = InputPerson.inputDate(scanner, "Дата рождения:");
    }
}
