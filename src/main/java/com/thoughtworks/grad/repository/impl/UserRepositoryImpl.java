package com.thoughtworks.grad.repository.impl;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.UserStorage;

import java.util.Collection;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Map<Integer, Contact> getUserContacts(int id) {
        return UserStorage.getUserContacts(id);
    }
}
