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
public class Teacher extends Worker{   // не самый удачный вариант - наследовать от моей реализации работника, но для лабы сойдёт
    @ToString.Include(name = "Предмет")
    String subject;
    @ToString.Include(name = "омер сертификата")
    String certificate_num;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.subject = InputPerson.inputString(scanner, "Преподаваемый предмет:");
        this.certificate_num = "";
        String msg = "Номер сертификата:";
        while (this.certificate_num == "")
            try {
                this.certificate_num= InputPerson.inputDigitString(scanner, msg);
            }
            catch (OnlyDigitEx ex) {
                msg = "Номер сертификата должен содержать только цифры!\n" + msg;
            }
    }

//    @Override
//    public String toString(){
//        return String.format("Преподаватель. " + super.toString() + ", преподаваемый предмет - %s, номер сертификата - %s", this.subject, this.certificate_num);
//    }
}
