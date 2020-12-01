package ru.bstu.iitus.vt41.kmi.enums;

import ru.bstu.iitus.vt41.kmi.person.*;

public enum PersonType {
    STUDENT(1, Student.class, "Студент"),
    SCHOOLBOY(2, Schoolboy.class, "Школьник"),
    WORKER(3, Worker.class, "Сотрудник"),
    TEACHER(4, Teacher.class, "Преподаватель"),
    DIRECTOR(5, Director.class, "Директор");

    int id;
    String label;
    Class<? extends Person> personClass;

    PersonType(int id, Class<? extends Person> aClass, String label) {
        this.id = id;
        this.personClass = aClass;
        this.label = label;
    }

    public Integer getID() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public Class<? extends Person> getPersonClass() {
        return personClass;
    }
    public static PersonType valueOfID(int id) {
        for (PersonType personType : values()) {
            if (personType.getID() == id) {
                return personType;
            }
        }
        throw new IllegalArgumentException("Введено не корректное значение");
    }
}
