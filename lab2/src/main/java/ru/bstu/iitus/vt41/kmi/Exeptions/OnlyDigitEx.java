package ru.bstu.iitus.vt41.kmi.Exeptions;

import lombok.Getter;

public class OnlyDigitEx extends Exception{
    @Getter
    private String str_number;
    public OnlyDigitEx(String message, String str_number){
        super(message);
        this.str_number = str_number;
    }
}
