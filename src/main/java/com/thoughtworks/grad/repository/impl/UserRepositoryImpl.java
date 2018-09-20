package com.thoughtworks.grad.repository.impl;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.UserStorage;

import java.util.Collection;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Map<Integer, Contact> getUserContacts(int id) {
        return UserStorage.getUserContacts(id);
    }

    @Override
    public User updateUserContact(int id, Contact contact) {
        return UserStorage.updateUserContact(id, contact);
    }
}
