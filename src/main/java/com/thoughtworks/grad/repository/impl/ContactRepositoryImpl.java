package com.thoughtworks.grad.repository.impl;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.repository.ContactRepository;
import com.thoughtworks.grad.repository.ContactStorage;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public Contact add(Contact contact) {
        return ContactStorage.add(contact);
    }

    @Override
    public Contact getContactByContactId(Integer id) {
        return ContactStorage.getContactByContactId(id);
    }

    @Override
    public Contact addForUser(int userId, Contact contact) {
        return ContactStorage.addForUser(userId, contact);
    }

    @Override
    public Contact updateForUser(int userId, int contactId, Contact contact) {
        return ContactStorage.updateForUser(userId,contactId, contact);
    }

    @Override
    public List<Contact> getContactsByUserId(int userId) {
        return ContactStorage.getContactsByUserId(userId);
    }

    @Override
    public void deleteForUser(int userId, int contactId) {
        ContactStorage.deleteForUser(userId, contactId);
    }

    @Override
    public Contact getUserContactByName(int userId, String contactName) {
        return ContactStorage.getUserContactByName(userId, contactName);
    }
}
