package com.thoughtworks.grad.controller;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
public class UserController {

    private UserRepository userRepository = new UserRepositoryImpl();

    @GetMapping("/user/{id}")
    public Map<Integer, Contact> getUserContacts(@PathVariable int id){
        return userRepository.getUserContacts(id);
    }

    @PutMapping ("/user/{id}/contact")
    public ResponseEntity<Contact> updateUserContact(@PathVariable int id, @RequestBody Contact contact){
        return new ResponseEntity<>(userRepository.updateUserContact(id, contact), HttpStatus.ACCEPTED);
    }
}
