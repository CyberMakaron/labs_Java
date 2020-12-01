package ru.bstu.iitus.vt41.kmi.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.bstu.iitus.vt41.kmi.service.InputPerson;

import java.util.Scanner;

@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
public class Director extends Worker {
    @ToString.Include(name = "Должность:")
    String post;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.post = InputPerson.inputString(scanner, "Директор какой масти:");
    }

//    @Override
//    public String toString(){
//        return String.format("%s. " + super.toString(), this.post);
//    }
}
