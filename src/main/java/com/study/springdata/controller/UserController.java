package com.study.springdata.controller;

import com.study.springdata.model.User;
import com.study.springdata.repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserJPARepository userJPARespository;

    @GetMapping("/user/all")
    public List<User> getUsers(){
        return userJPARespository.findAll();
    }

    @GetMapping("/user/{name}")
    public User findByName(@PathVariable final String name){
        return userJPARespository.findByName(name);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody final User user){
        return userJPARespository.save(user);
    }
}
