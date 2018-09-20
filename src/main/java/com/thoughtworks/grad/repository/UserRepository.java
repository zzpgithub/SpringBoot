package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;

import java.util.Collection;
import java.util.Map;

public interface UserRepository {
    Map<Integer, Contact> getUserContacts(int id);

    User updateUserContact(int id, Contact contact);
}
