package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;

import java.util.List;

public interface ContactRepository {
    Contact add(Contact contact);

    Contact getContactByContactId(Integer id);

    Contact addForUser(int userId, Contact contact);

    Contact updateForUser(int userId, int contactId, Contact contact);

    List<Contact> getContactsByUserId(int userId);

    void deleteForUser(int userId, int contactId);

    Contact getUserContactByName(int userId, String contactName);
}
