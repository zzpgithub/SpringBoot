package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContactStorage {
    private static final Map<Integer, Contact> CONTACTS = new HashMap<>();

    static{
        CONTACTS.put(1, new Contact(1, 5, 20, "male", "personOne", "111-1111"));
        CONTACTS.put(2, new Contact(2, 5, 21, "male", "personTwo", "222-2222"));
    }

    public static Map<Integer, Contact> getCONTACTS() {
        return CONTACTS;
    }

    public static Contact add(Contact contact){
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    public static Contact getContactByContactId(int id) {
        return CONTACTS.get(id);
    }

    public static Contact addForUser(int userId, Contact contact) {
        CONTACTS.put(contact.getId(), contact);
        return contact;
    }

    //    public static Contact updateUserContact(int id, Contact contact) {
//        Contact originalContact = USERS.get(id).getContacts().get(contact.getId());
//        originalContact.setAge(contact.getAge());
//        originalContact.setName(contact.getName());
//        originalContact.setGender(contact.getGender());
//        originalContact.setPhoneNumber(contact.getPhoneNumber());
//        return contact;
//    }

    public static Contact updateForUser(int userId, int contactId, Contact contact) {
        Contact originalContact = CONTACTS.get(contactId);
        originalContact.setAge(contact.getAge());
        originalContact.setName(contact.getName());
        originalContact.setGender(contact.getGender());
        originalContact.setPhoneNumber(contact.getPhoneNumber());
        return contact;
    }

    public static List<Contact> getContactsByUserId(int userId) {
        return CONTACTS.values().stream().filter(contact -> contact.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public static void deleteForUser(int userId, int contactId) {
        CONTACTS.remove(contactId);
    }

    public static Contact getUserContactByName(int userId, String contactName) {
        List<Contact> contacts = getContactsByUserId(userId);
        Contact[] contactsResult = new Contact[1];
        contacts.stream().forEach(contact -> {
            if (contact.getName().equals(contactName)) {
                contactsResult[0] = contact;
            }
        });
        return contactsResult[0];
    }
}
