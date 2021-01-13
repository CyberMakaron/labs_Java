package ru.bstu.iitus.vt41.kmi.enums;

import java.lang.String;
import lombok.Getter;
import ru.bstu.iitus.vt41.kmi.person.*;

@Getter
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
    public static PersonType valueOfID(int id) throws IllegalArgumentException{
        for (PersonType personType : values()) {
            if (personType.getId() == id) {
                return personType;
            }
        }
        throw new IllegalArgumentException("Передано несуществующее значение");
    }
    public static PersonType valueOfLabel(String label) throws IllegalArgumentException{
        for (PersonType personType : values()) {
            if (personType.getLabel().equals(label)) {
                return personType;
            }
        }
        throw new IllegalArgumentException("Передано несуществующее значение");
    }
}
