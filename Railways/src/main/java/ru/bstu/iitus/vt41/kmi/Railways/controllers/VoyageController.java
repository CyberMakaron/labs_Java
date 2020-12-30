package ru.bstu.iitus.vt41.kmi.Railways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bstu.iitus.vt41.kmi.Railways.models.Voyage;
import ru.bstu.iitus.vt41.kmi.Railways.repo.VoyageRepository;
import ru.bstu.iitus.vt41.kmi.Railways.services.VoyageService;

import java.util.List;

@RestController
public class VoyageController {
    @Autowired
    private VoyageService service_voyage;

    @GetMapping("voyage/voyages/{departId}/{arriveId}/{departDate}")
    private List<Voyage> VoyagesByOptions(@PathVariable("departId") Long departId,
                                          @PathVariable("arriveId") Long arriveId,
                                          @PathVariable("departDate") String departDate){
        return service_voyage.Voyages(departId, arriveId, departDate);
    }
}
