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
public class Teacher extends Worker{   // не самый удачный вариант - наследовать от моей реализации работника, но для лабы сойдёт
    @ToString.Include(name = "Предмет")
    String subject;
    @ToString.Include(name = "омер сертификата")
    String certificateNum;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.subject = InputPerson.inputString(scanner, "Преподаваемый предмет:");
        this.certificateNum = "";
        String msg = "Номер сертификата:";
        while (this.certificateNum.equals(""))
            try {
                this.certificateNum= InputPerson.inputDigitString(scanner, msg);
            }
            catch (OnlyDigitException ex) {
                msg = "Номер сертификата должен содержать только цифры!\n" + msg;
            }
    }
}
