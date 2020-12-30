package ru.bstu.iitus.vt41.kmi.Railways.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bstu.iitus.vt41.kmi.Railways.models.Train;

public interface TrainRepository extends CrudRepository<Train, Long> {
}
