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
import java.util.Map;

@RestController
public class UserController {
    // TODO: 2018/9/21  api设计需要更改
    private UserRepository userRepository = new UserRepositoryImpl();
    private ContactRepository contactRepository = new ContactRepositoryImpl();

    @PostMapping("/api/users/{userId}/contacts")// 1. 给User(id=5)创建一个Contact
    public ResponseEntity<Contact> addContactForUser(@PathVariable int userId, @RequestBody Contact contact) {
        return new ResponseEntity<>(contactRepository.addForUser(userId, contact), HttpStatus.CREATED);
    }

    @GetMapping("/api/users/{userId}/contacts") //2. 查询User(id=5)的Contact
    public List<Contact> getUserContacts(@PathVariable int userId){
        return contactRepository.getContactsByUserId(userId);
    }

    @PutMapping ("/api/users/{userId}/contacts/{contactId}")  //更新User(id=5)的某个Contact
    public ResponseEntity<Contact> updateUserContact(@PathVariable int userId, @PathVariable int contactId, @RequestBody Contact contact){
        return new ResponseEntity<>(contactRepository.updateForUser(userId, contactId,contact), HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/api/users/{userId}/contacts/{contactId}") ///删除User(id=5)的某个Contact
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserContact(@PathVariable int userId, @PathVariable int contactId){
        contactRepository.deleteForUser(userId, contactId);
    }

    @GetMapping("/api/users/{userName}/contacts/{contactName}")
    public Contact getUserContactByName(@PathVariable String userName, @PathVariable String contactName) {
        User user = userRepository.findUserByName(userName);
        return contactRepository.getUserContactByName(user.getId(), contactName);
    }
//    @PostMapping("/user/{id}/contact")
//    public ResponseEntity<Contact> saveUserContact(@PathVariable int id, @RequestBody Contact contact) {
//        return new ResponseEntity<>(userRepository.saveUserContact(id, contact), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/user/{id}")
//    public Map<Integer, Contact> getUserContacts(@PathVariable int id){
//        return userRepository.getUserContacts(id);
//    }
//
//    @PutMapping ("/user/{id}/contact")
//    public ResponseEntity<Contact> updateUserContact(@PathVariable int id, @RequestBody Contact contact){
//        return new ResponseEntity<>(userRepository.updateUserContact(id, contact), HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping ("/user/{id}/contact/{contactId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUserContact(@PathVariable int id, @PathVariable int contactId){
//        userRepository.deleteUserContact(id, contactId);
//    }
//
//    @GetMapping("/user/contact")
//    public Contact getUserContact(@RequestParam String userName, @RequestParam String contactName) {
//        return userRepository.getUserContactByName(userName, contactName);
//    }
}
