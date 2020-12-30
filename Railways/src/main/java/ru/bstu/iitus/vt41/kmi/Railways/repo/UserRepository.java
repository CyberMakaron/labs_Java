package ru.bstu.iitus.vt41.kmi.Railways.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bstu.iitus.vt41.kmi.Railways.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
}
