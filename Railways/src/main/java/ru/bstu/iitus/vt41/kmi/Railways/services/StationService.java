package ru.bstu.iitus.vt41.kmi.Railways.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bstu.iitus.vt41.kmi.Railways.models.Station;
import ru.bstu.iitus.vt41.kmi.Railways.repo.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    StationRepository rep_station;
    public List<Station> StationById(Long id){
        Optional<Station> station = rep_station.findById(id);
        List<Station> list = new ArrayList<>();
        list.add(station.get());
        return list;
    }
}
