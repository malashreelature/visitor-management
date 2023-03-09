package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.User;

import java.util.List;

public interface UserDataService {

    public List<User> getAll();

    void deleteUserById(Long userId);

    User getUserById(Long userId);

    User saveuser(User user);
}
