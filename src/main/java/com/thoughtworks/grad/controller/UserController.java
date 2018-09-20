package com.thoughtworks.grad.controller;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    private UserRepository userRepository = new UserRepositoryImpl();

    @PostMapping("/user/{id}/contact")
    public ResponseEntity<Contact> saveUserContact(@PathVariable int id, @RequestBody Contact contact) {
        return new ResponseEntity<>(userRepository.saveUserContact(id, contact), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public Map<Integer, Contact> getUserContacts(@PathVariable int id){
        return userRepository.getUserContacts(id);
    }

    @PutMapping ("/user/{id}/contact")
    public ResponseEntity<Contact> updateUserContact(@PathVariable int id, @RequestBody Contact contact){
        return new ResponseEntity<>(userRepository.updateUserContact(id, contact), HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/user/{id}/contact/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserContact(@PathVariable int id, @PathVariable int contactId){
        userRepository.deleteUserContact(id, contactId);
    }

    @GetMapping("/user/contact")
    public Contact getUserContact(@RequestParam String userName, @RequestParam String contactName) {
        return userRepository.getUserContactByName(userName, contactName);
    }
}
