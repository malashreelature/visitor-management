package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.model.BadgesModel;
import com.diatoz.visitor.management.repository.BadgesRepository;
import com.diatoz.visitor.management.service.BadgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgesServiceImpl implements BadgesService {

    @Autowired
    BadgesRepository badgesRepository;

    @Override
    public List<Badges> getAll() {
        return badgesRepository.findAll();
    }

    @Override
    public BadgesModel findById(Long id) {
    BadgesModel model= new BadgesModel();
        try {
            model.setBadges((Badges) badgesRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException("Badges with id not found")));
            model.setErrorMessage(" ");
            if (!model.getBadges().getId().equals(id)) {
                throw new EntityNotFoundException("");
            }
        } catch (EntityNotFoundException e) {
            model.setBadges(null);
            model.setErrorMessage(e.getMessage());
        }
        return model;
    }



    @Override
    public BadgesModel saveBadges(Badges badges) throws AlreadyExistsException {
        BadgesModel model= new BadgesModel();

        try {
            model.setBadges((Badges) badgesRepository.save(badges));
            if (model != null) {
                badgesRepository.save(badges);

            } else {
                throw new AlreadyExistsException(
                        "badges already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("Badges already exists!!");
        }

        return model;
    }


    @Override
    public BadgesModel deleteById(Long id) {
            BadgesModel model= new BadgesModel();
        try {
            if (!badgesRepository.existsById(id)) {
                throw new EntityNotFoundException(" Badges with id not exists");
            }
            badgesRepository.deleteById(id);

        } catch (EntityNotFoundException e) {
            model.setErrorMessage(e.getMessage());
        }
        return model;

    }
}
