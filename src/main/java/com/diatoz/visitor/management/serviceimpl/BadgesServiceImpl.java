package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
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
    public Badges getBadgesById(Long id) {
        Badges badges = badgesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Badges", "id", id));
        return badgesRepository.getById(id);
    }



    @Override
    public Badges saveBadges(Badges badges){
        return badgesRepository.save(badges);

    }


    @Override
    public void deleteBadgesById(Long id) {
        Badges badges = badgesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Badges", "id", id));
        badgesRepository.deleteById(id);
    }
}



