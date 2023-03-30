package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.AccessControl;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.repository.AcessControlRepository;
import com.diatoz.visitor.management.service.AccessControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessControlServiceImpl implements AccessControlService {

    @Autowired
    AcessControlRepository acessControlRepository;

    @Override
    public List<AccessControl> getAll() {
        return acessControlRepository.findAll();
    }


    @Override
    public AccessControl getAccessById(Long accessId) {
        AccessControl AcessControl = acessControlRepository.findById(accessId).orElseThrow(() ->
                new ResourceNotFoundException("AccessControl", "id", accessId));
        return AcessControl;
    }



    @Override
    public AccessControl saveAcessControl(AccessControl acessControl ){
        return acessControlRepository.save(acessControl);

    }


    @Override
    public void deleteAccessById(Long accessId) {
        AccessControl acessControl = acessControlRepository.findById(accessId).orElseThrow(() ->
                new ResourceNotFoundException("AccessControl", "accessId", accessId));
        acessControlRepository.deleteById(accessId);
    }
}


