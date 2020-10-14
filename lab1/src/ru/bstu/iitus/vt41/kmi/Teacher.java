package ru.bstu.iitus.vt41.kmi;

import java.util.Scanner;

public class Teacher extends Worker{   // не самый удачный вариант - наследовать от моей реализации работника, но для лабы сойдёт
    String subject;
    String certificate_num;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.subject = InputPerson.inputString(scanner, "Преподаваемый предмет:");
        this.certificate_num = InputPerson.inputString(scanner, "Номер сертификата:");
    }

    @Override
    public String toString(){
        return String.format("Преподаватель. " + super.toString() + ", преподаваемый предмет - %s, номер сертификата - %s", this.subject, this.certificate_num);
    }
}
