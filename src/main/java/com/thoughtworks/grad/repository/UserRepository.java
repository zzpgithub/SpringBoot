package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;

import java.util.Collection;
import java.util.Map;

public interface UserRepository {
    Collection<User> getUsers();

    User findUserByName(String userName);
//    Contact saveUserContact(int id, Contact contact);
//
//    Map<Integer, Contact> getUserContacts(int id);
//
//    Contact updateUserContact(int id, Contact contact);
//
//    void deleteUserContact(int id, int contactId);
//
//    Contact getUserContactByName(String userName, String contactName);
}
