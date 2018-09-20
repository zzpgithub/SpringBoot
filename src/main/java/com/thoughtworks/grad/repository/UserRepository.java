package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;

import java.util.Collection;
import java.util.Map;

public interface UserRepository {
    Map<Integer, Contact> getUserContacts(int id);
}
