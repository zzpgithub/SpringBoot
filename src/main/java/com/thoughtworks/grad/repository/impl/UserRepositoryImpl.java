package com.thoughtworks.grad.repository.impl;

import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserRepository;
import com.thoughtworks.grad.repository.UserStorage;

import java.util.Collection;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Collection<User> getUsers() {
        return UserStorage.getUsers();
    }

    @Override
    public User findUserByName(String userName) {
        User user = UserStorage.findUserByName(userName);
        return user;
    }
}
