package ru.bstu.iitus.vt41.kmi.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputPerson {
    public static int inputInteger(Scanner scanner, String msg){
        int value = 0;
        boolean flag = true;
        while(flag){    // либо рекурсия
            try{
                System.out.println(msg);
                value = scanner.nextInt();
                flag = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Данные введены неверно! Повторите ввод.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return value;
    };

    public static String inputString(Scanner scanner, String msg){
        String str;
        System.out.println(msg);
        str = scanner.nextLine();
        return str;
    }

    public static Calendar inputDate(Scanner scanner, String msg){
        System.out.println(msg);
        int year = inputInteger(scanner, "Год:");
        int month = inputInteger(scanner, "Месяц:");
        int day = inputInteger(scanner, "День:");
        while (!dateIsValid(year, month, day)){
            System.out.println("Дата введена неверной! Повторите ввод.");
            year = inputInteger(scanner, "Год:");
            month = inputInteger(scanner, "Месяц:");
            day = inputInteger(scanner, "День:");
        }
        GregorianCalendar date = new GregorianCalendar(year, month, day);
        return date;
    }

    private static boolean dateIsValid(int y, int m, int d){
        try {
            LocalDate ld = LocalDate.of(y, m, d);
            return Boolean.TRUE ;
        } catch ( DateTimeException ex ) {
            return Boolean.FALSE ;
        }
    }
}
