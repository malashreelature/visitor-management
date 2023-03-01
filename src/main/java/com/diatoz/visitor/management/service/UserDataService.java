package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.model.UserModel;
import com.diatoz.visitor.management.exception.AlreadyExistsException;

import java.util.List;

public interface UserDataService {

    public List<User> getAll();
    UserModel findById(Long userId);

    Object  saveUser(User user)throws AlreadyExistsException;

    UserModel deleteById(Long userId);

}
