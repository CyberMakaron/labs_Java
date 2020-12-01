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
public class Worker extends Person {
    @ToString.Include(name = "Организация")
    String organization;
    @ToString.Include(name = "Табельный номер")
    String tab_num;
    // хорошо бы добавить должность, но тогда не вяжется toString в наследуемых классах - придётся переопределять полностью

    @Override
    public void init(Scanner scanner){
        System.out.println("Введите данные о сотруднике:");
        super.name = InputPerson.inputString(scanner, "Имя сотрудника:");
        this.organization = InputPerson.inputString(scanner, "Наименование организации:");
        this.tab_num = "";
        String msg = "Табельный номер:";
        while (this.tab_num == "")
        try {
            this.tab_num = InputPerson.inputDigitString(scanner, msg);
        }
        catch (OnlyDigitEx ex) {
            msg = "Табельный номер должен содержать только цифры!\n" + msg;
        }
        super.b_day = InputPerson.inputDate(scanner, "Дата рождения:");
    }

//    @Override
//    public String toString(){
//        return String.format("Сотрудник организации \"%s\", %s, табельный номер - %s, возраст - %d",
//                this.organization, this.name, this.tab_num, getAge());
//    }
}
