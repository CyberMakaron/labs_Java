package ru.bstu.iitus.vt41.kmi.Railways.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer basePrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private Station depart;

    @ManyToOne(fetch = FetchType.EAGER)
    private Station arrive;
}
