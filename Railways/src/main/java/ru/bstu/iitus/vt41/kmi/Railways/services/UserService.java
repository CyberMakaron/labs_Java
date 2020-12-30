package ru.bstu.iitus.vt41.kmi.Railways.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bstu.iitus.vt41.kmi.Railways.models.User;
import ru.bstu.iitus.vt41.kmi.Railways.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository rep_user;
    public List<User> Login(String email, String password){
        List<User> res = rep_user.findByEmail(email);
        if (res.size() == 0)
            return res;
        String pas = res.get(0).getPassword();
        if (!pas.equals(password))
            res.remove(0);
        return res;
    }
    public List<User> Registration(String email, String password){
        List<User> res = rep_user.findByEmail(email);
        if (res.size() != 0) {
            res.remove(0);
            return res;
        }
        User user = new User(email, password);
        rep_user.save(user);
        res.add(user);
        return res;
    }

}
