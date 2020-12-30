package ru.bstu.iitus.vt41.kmi.Railways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bstu.iitus.vt41.kmi.Railways.models.Station;
import ru.bstu.iitus.vt41.kmi.Railways.repo.StationRepository;
import ru.bstu.iitus.vt41.kmi.Railways.services.StationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StationsController {

    @Autowired
    private StationRepository rep_station;
    @Autowired
    StationService service_station;

    @GetMapping("/station/stationById/{id}")
    private List<Station> StationById(@PathVariable("id") Long id){
        return service_station.StationById(id);
    }

    @GetMapping("/station/all_departs")
    private List<Station> Departs(){
        return (List<Station>) rep_station.findAll();
    }

    @GetMapping("/station/all_arrives")
    private List<Station> Arrives(){
        return (List<Station>) rep_station.findAll();
    }
}
