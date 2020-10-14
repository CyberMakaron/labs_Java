package ru.bstu.iitus.vt41.kmi;

import java.util.Scanner;

public class Director extends Worker{
    String post;

    @Override
    public void init(Scanner scanner){
        super.init(scanner);
        this.post = InputPerson.inputString(scanner, "Директор какой масти:");
    }

    @Override
    public String toString(){
        return String.format("%s. " + super.toString(), this.post);
    }
}
