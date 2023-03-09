package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.repository.UserDataRepository;
import com.diatoz.visitor.management.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public List<User> getAll() {
        return userDataRepository.findAll();
    }



    @Override
    public User getUserById(Long userId) {
        User user = userDataRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
        return userDataRepository.getById(userId);
    }



    @Override
    public User saveuser(User user){
        return userDataRepository.save(user);

    }


    @Override
    public void deleteUserById(Long userId) {
        User user = userDataRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", userId));
        userDataRepository.deleteById(userId);
    }
}



