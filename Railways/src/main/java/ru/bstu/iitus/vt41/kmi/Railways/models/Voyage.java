package ru.bstu.iitus.vt41.kmi.Railways.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rout rout;

    @ManyToOne(fetch = FetchType.EAGER)
    private Train train;

    private String departDate;
    private String departTime;
    private String arriveDate;
    private String arriveTime;

}
