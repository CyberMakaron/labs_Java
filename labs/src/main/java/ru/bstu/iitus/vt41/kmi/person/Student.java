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
public class Student extends Person {
    @ToString.Include(name = "Группа")
    String group;
    @ToString.Include(name = "Институт")
    String institute;
    @ToString.Include(name = "Номер зачётки")
    String creditCardNum;
    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о студенте:");
        super.name = InputPerson.inputString(scanner, "Имя студента:");
        this.group = InputPerson.inputString(scanner, "Группа:");
        this.institute = InputPerson.inputString(scanner, "Институт:");
        this.creditCardNum = "";
        String msg = "Номер зачётки:";
        while (this.creditCardNum.equals(""))
            try {
                this.creditCardNum = InputPerson.inputDigitString(scanner, msg);
            }
            catch (OnlyDigitException ex) {
                msg = "Номер зачётки должен содержать только цифры!\n" + msg;
            }
        super.birthday = InputPerson.inputDate(scanner, "Дата рождения:");
    }
}