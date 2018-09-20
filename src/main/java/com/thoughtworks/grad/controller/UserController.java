package com.thoughtworks.grad.controller;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.impl.UserRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class UserController {

    private UserRepository userRepository = new UserRepositoryImpl();

    @GetMapping("/user/{id}")
    public Map<Integer, Contact> getUserContacts(@PathVariable int id){
        return userRepository.getUserContacts(id);
    }
}
