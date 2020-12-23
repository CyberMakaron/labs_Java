package ru.bstu.iitus.vt41.kmi.Railways.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bstu.iitus.vt41.kmi.Railways.models.Station;
import ru.bstu.iitus.vt41.kmi.Railways.repo.StationsRepository;

import java.util.List;

@RestController
public class StationsController {

    private final StationsRepository repository;

    StationsController(StationsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stations/departs")
    List<Station> departs(){
        return (List<Station>) repository.findAll();
    }

    @GetMapping("/stations/arrives")
    List<Station> arrives(){
        return (List<Station>) repository.findAll();
    }
}
