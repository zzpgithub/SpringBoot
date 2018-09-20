package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static final Map<Integer, User> USERS = new HashMap<>();

    static {
        Map<Integer, Contact> contacts = new HashMap<>();
        Contact contactOne = new Contact(1, 20, "male", "Jack ContactOne", "111-1111");
        Contact contactTwo = new Contact(2, 21, "male", "Jack ContactTwo", "222-2222");
        contacts.put(1, contactOne);
        contacts.put(2, contactTwo);

        USERS.put(5, new User(5, "Jack User", contacts));
    }

    public static void clear() {
        USERS.clear();
    }

    public static void addUser(User... user) {
        Arrays.stream(user).forEach(person -> {
            USERS.put(person.getId(), person);
        });
    }

    public static Map<Integer, Contact> getUserContacts(int id) {
        return USERS.get(id).getContacts();
    }

    public static Contact updateUserContact(int id, Contact contact) {
        Contact originalContact = USERS.get(id).getContacts().get(contact.getId());
        originalContact.setAge(contact.getAge());
        originalContact.setName(contact.getName());
        originalContact.setGender(contact.getGender());
        originalContact.setPhoneNumber(contact.getPhoneNumber());
        return contact;
    }

    public static Contact saveUserContact(int id, Contact contact) {
        USERS.get(id).getContacts().put(contact.getId(), contact);
        return contact;
    }

    public static void deleteUserContact(int id, int contactId) {
        USERS.get(id).getContacts().remove(contactId);
    }

    public static Contact getUserContactByName(String userName, String contactName) {
        for(Integer key : USERS.keySet()){
            if (USERS.get(key).getName().equals(userName)) {
                for(Integer contactKey : USERS.get(key).getContacts().keySet()){
                    if(USERS.get(key).getContacts().get(contactKey).getName().equals(contactName)){
                        return USERS.get(key).getContacts().get(contactKey);
                    }
                }
            }
        }
        return null;
    }
}

