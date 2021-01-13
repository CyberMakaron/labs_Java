package ru.bstu.iitus.vt41.kmi.Exeptions;

import lombok.Getter;

public class OnlyDigitException extends Exception{
    @Getter
    private String strNumber;
    public OnlyDigitException(String message, String strNumber){
        super(message);
        this.strNumber = strNumber;
    }
}
