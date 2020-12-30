package ru.bstu.iitus.vt41.kmi.Railways.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bstu.iitus.vt41.kmi.Railways.models.User;
import ru.bstu.iitus.vt41.kmi.Railways.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UserService service;

    @GetMapping("/user/login/{email}/{password}")
    private List<User> Login(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.Login(email, password);
    }

    @PostMapping(value = "/user/registration", consumes = "application/json", produces = "application/json")
    private List<User> Registration(@RequestBody User user){
        return service.Registration(user.getEmail(), user.getPassword());
    }
}
