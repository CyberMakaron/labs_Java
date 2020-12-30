package ru.bstu.iitus.vt41.kmi.Railways.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Float economyMultiplierTop;
    private Float economyMultiplierBot;
    private Float coupMultiplierTop;
    private Float coupMultiplierBot;

}
