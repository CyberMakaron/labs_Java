package ru.bstu.iitus.vt41.kmi.Railways.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bstu.iitus.vt41.kmi.Railways.models.Rout;
import ru.bstu.iitus.vt41.kmi.Railways.models.User;
import ru.bstu.iitus.vt41.kmi.Railways.models.Voyage;

import java.util.List;

public interface VoyageRepository extends CrudRepository<Voyage, Long> {
    List<Voyage> findByRoutAndDepartDate(Rout rout, String departDate);
}
