package ru.bstu.iitus.vt41.kmi.Railways.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bstu.iitus.vt41.kmi.Railways.models.Rout;

public interface RoutRepository extends CrudRepository<Rout, Long> {
    Rout findByDepartIdAndArriveId(Long departId, Long arriveId);
}
