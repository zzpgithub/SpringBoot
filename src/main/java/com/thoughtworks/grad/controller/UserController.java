package com.thoughtworks.grad.controller;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.ContactRepository;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.impl.ContactRepositoryImpl;
import com.thoughtworks.grad.repository.impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository = new UserRepositoryImpl();
    private ContactRepository contactRepository = new ContactRepositoryImpl();

    @PostMapping("/api/users/{userId}/contacts")
    public ResponseEntity<Contact> addContactForUser(@PathVariable int userId, @RequestBody Contact contact) {
        return new ResponseEntity<>(contactRepository.addForUser(userId, contact), HttpStatus.CREATED);
    }

    @GetMapping("/api/users/{userId}/contacts")
    public List<Contact> getUserContacts(@PathVariable int userId){
        return contactRepository.getContactsByUserId(userId);
    }

    @PutMapping ("/api/users/{userId}/contacts/{contactId}")
    public ResponseEntity<Contact> updateUserContact(@PathVariable int userId, @PathVariable int contactId, @RequestBody Contact contact){
        return new ResponseEntity<>(contactRepository.updateForUser(userId, contactId,contact), HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/api/users/{userId}/contacts/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserContact(@PathVariable int userId, @PathVariable int contactId){
        contactRepository.deleteForUser(userId, contactId);
    }

    @GetMapping("/api/users/{userName}/contacts/{contactName}")
    public Contact getUserContactByName(@PathVariable String userName, @PathVariable String contactName) {
        User user = userRepository.findUserByName(userName);
        return contactRepository.getUserContactByName(user.getId(), contactName);
    }
}
