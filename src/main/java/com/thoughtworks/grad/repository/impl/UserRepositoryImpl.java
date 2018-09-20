package com.thoughtworks.grad.repository.impl;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.UserStorage;

import java.util.Collection;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public Contact saveUserContact(int id, Contact contact) {
        return UserStorage.saveUserContact(id, contact);
    }

    @Override
    public Map<Integer, Contact> getUserContacts(int id) {
        return UserStorage.getUserContacts(id);
    }

    @Override
    public Contact updateUserContact(int id, Contact contact) {
        return UserStorage.updateUserContact(id, contact);
    }

    @Override
    public void deleteUserContact(int id, int contactId) {
        UserStorage.deleteUserContact(id, contactId);
    }

    @Override
    public Contact getUserContactByName(String userName, String contactName) {
        return UserStorage.getUserContactByName(userName, contactName);
    }
}
