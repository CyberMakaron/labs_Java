package ru.bstu.iitus.vt41.kmi;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkWthPersons {
    public static ArrayList<Person> inputPersons(Scanner scanner){
        System.out.print("Введите количество человек: ");
        int count = scanner.nextInt();
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < count; i++){
            list.add(inputPerson(scanner));
        }
        return list;
    }

    public static Person inputPerson(Scanner scanner){
        Person person = null;
        int mode = InputPerson.inputInteger(scanner, "Укажите тип вводимой записи:\n" +
                                                "1. Студент\n" +
                                                "2. Школьник\n" +
                                                "3. Сотрудник\n" +
                                                "4. Преподаватель\n" +
                                                "5. Директор");
        boolean flag;
        do{
            flag = false;
            switch (mode){
                case 1: person = inputStudent(scanner); break;
                case 2: person = inputSchoolboy(scanner); break;
                case 3: person = inputWorker(scanner); break;
                case 4: person = inputTeacher(scanner); break;
                case 5: person = inputDirector(scanner); break;
                default: System.out.print("Введён неверный номер! Повторите ввод: ");
                        flag = true;
            }
        } while (flag);
        return person;
    }

    static Person getJunior(ArrayList<Person> persons){
        int maxAge = Integer.MAX_VALUE;
        Person junior_person = null;
        for (Person p : persons){
            int cur_age = p.getAge();
            if (cur_age < maxAge) {
                maxAge = cur_age;
                junior_person = p;
            }
        }
        return junior_person;
    }

    public static Person inputStudent(Scanner scanner){
        Student student = new Student();
        student.init(scanner);
        return student;
    }

    public static Person inputSchoolboy(Scanner scanner){
        Schoolboy sch_boy = new Schoolboy();
        sch_boy.init(scanner);
        return sch_boy;
    }

    public static Person inputWorker(Scanner scanner){
        Worker worker = new Worker();
        worker.init(scanner);
        return worker;
    }

    public static Person inputTeacher(Scanner scanner){
        Teacher teacher = new Teacher();
        teacher.init(scanner);
        return teacher;
    }

    public static Person inputDirector(Scanner scanner){
        Director director = new Director();
        director.init(scanner);
        return director;
    }
}
