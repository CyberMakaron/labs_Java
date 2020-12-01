package ru.bstu.iitus.vt41.kmi.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.bstu.iitus.vt41.kmi.Exeptions.OnlyDigitEx;
import ru.bstu.iitus.vt41.kmi.service.InputPerson;

import java.util.Scanner;

@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
public class Student extends Person {
    @ToString.Include(name = "Группа")
    String group;
    @ToString.Include(name = "Институт")
    String institute;
    @ToString.Include(name = "Номер зачётки")
    String credit_cadr_num;

    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о студенте:");
        super.name = InputPerson.inputString(scanner, "Имя студента:");
        this.group = InputPerson.inputString(scanner, "Группа:");
        this.institute = InputPerson.inputString(scanner, "Институт:");
        this.credit_cadr_num = "";
        String msg = "Номер зачётки:";
        while (this.credit_cadr_num == "")
            try {
                this.credit_cadr_num = InputPerson.inputDigitString(scanner, msg);
            }
            catch (OnlyDigitEx ex) {
                msg = "Номер зачётки должен содержать только цифры!\n" + msg;
            }
        super.b_day = InputPerson.inputDate(scanner, "Дата рождения:");
    }

//    @Override
//    public String toString(){
//        return String.format("Студент %s группы %s, институт - %s, номер зачётки - %s, возраст - %d",
//                this.name, this.group, this.institute, this.credit_cadr_num, getAge());
//    }
}