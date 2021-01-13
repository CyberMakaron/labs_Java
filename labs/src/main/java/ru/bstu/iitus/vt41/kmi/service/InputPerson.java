package ru.bstu.iitus.vt41.kmi.service;

import ru.bstu.iitus.vt41.kmi.Exeptions.OnlyDigitException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputPerson {
    public static int inputInteger(Scanner scanner, String msg){
        int value = 0;
        boolean flag = true;
        while(flag){
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
    }
    public static String inputString(Scanner scanner, String msg){
        String str;
        System.out.println(msg);
        str = scanner.nextLine();
        return str;
    }
    //ввод строки из чисел (длинное число, например номер сертификата)
    public static String inputDigitString(Scanner scanner, String msg) throws OnlyDigitException {
        String str;
        System.out.println(msg);
        str = scanner.nextLine();
        checkDigitString(str);
        return str;
    }
    public static void checkDigitString(String str) throws OnlyDigitException {
        if (str == null)
            throw new OnlyDigitException("Строка не инициализирована!", "");
        if (!str.matches("\\d+"))
            throw new OnlyDigitException("Строка содержит нечисловые значения", str);
    }
    public static LocalDate inputDate(Scanner scanner, String msg){
        System.out.println(msg);
        String stringDate = inputString(scanner, "Введите дату в формфте ДД.ММ.ГГГГ");
        LocalDate date = getLocalDate(stringDate);
        while (date == null){
            stringDate = inputString(scanner, "Дата введена неверно! Повторите ввод.");
            date = getLocalDate(stringDate);
        }
        return date;
    }
    public static LocalDate getLocalDate(String date){
        String[] splitedDate;
        if (date.matches("(\\d{2}\\.){2}\\d{4}")) {
            splitedDate = date.split("\\.");
        } else {
            return null;
        }
        try {
            return LocalDate.of(Integer.parseInt(splitedDate[2]), Integer.parseInt(splitedDate[1]), Integer.parseInt(splitedDate[0]));
        } catch (DateTimeException ex) {
            return null;
        }
    }
}
