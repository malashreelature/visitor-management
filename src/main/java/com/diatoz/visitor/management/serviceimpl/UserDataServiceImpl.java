package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.model.UserModel;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.repository.UserDataRepository;
import com.diatoz.visitor.management.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public UserModel findById(Long userId) {
        UserModel model1 = new UserModel();
        try {
            model1.setUser((User) userDataRepository.findById(userId).orElseThrow(() ->
                    new EntityNotFoundException("User with id not found")));
            model1.setErrorMessage(" ");
            if (!model1.getUser().getUserId().equals(userId)) {
                throw new EntityNotFoundException("");

            }
        } catch (EntityNotFoundException e) {
            model1.setUser(null);
            model1.setErrorMessage(e.getMessage());
        }
        return model1;
    }

    @Override
    public UserModel saveUser(User user) throws AlreadyExistsException {
        UserModel model = new UserModel();
        try {
            model.setUser((User) userDataRepository.save(user));
            if (model != null) {
                userDataRepository.save(user);

            } else {
                throw new AlreadyExistsException(
                        "user already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("user already exists!!");
        }
        return model;
    }

    @Override
    public UserModel deleteById(Long userId) {
        UserModel model1 = new UserModel();
        try {
            if (userDataRepository.existsById(userId)) {
                throw new EntityNotFoundException("Invlaid Id was provided");
            }

            userDataRepository.deleteById(userId);


        } catch (Exception e) {
            model1.setErrorMessage(e.getMessage());
        }
        return model1;
    }
}



