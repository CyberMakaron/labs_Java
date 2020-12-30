package ru.bstu.iitus.vt41.kmi.Railways.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bstu.iitus.vt41.kmi.Railways.models.Rout;
import ru.bstu.iitus.vt41.kmi.Railways.models.Voyage;
import ru.bstu.iitus.vt41.kmi.Railways.repo.RoutRepository;
import ru.bstu.iitus.vt41.kmi.Railways.repo.VoyageRepository;

import java.util.List;

@Service
public class VoyageService {
    @Autowired
    VoyageRepository rep_voyage;
    @Autowired
    RoutRepository rep_rout;
    public List<Voyage> Voyages(Long departId, Long arriveId, String departDate){
        Rout rout = rep_rout.findByDepartIdAndArriveId(departId, arriveId);
        return rep_voyage.findByRoutAndDepartDate(rout, departDate);
    }
}
