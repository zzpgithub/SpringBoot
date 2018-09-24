package com.thoughtworks.grad.repository;

import com.thoughtworks.grad.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static final Map<Integer, User> USERS = new HashMap<>();

    static {
        USERS.put(1, new User(5, "Jack"));
        USERS.put(2, new User(2, "Another"));
    }

    public static Map<Integer, User> getUSERS() {
        return USERS;
    }

    public static Collection<User> getUsers() {
        return USERS.values();
    }

    public static void clear() {
        USERS.clear();
    }

    public static User findUserByName(String userName) {
        User[] users = new User[1];
        USERS.forEach((id, user) -> {
            if (user.getName().equals(userName)) {
                users[0] = user;
            }
        });
        return users[0];
    }
}

