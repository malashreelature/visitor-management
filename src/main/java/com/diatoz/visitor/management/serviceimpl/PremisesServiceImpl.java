package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.repository.PremisesRepository;
import com.diatoz.visitor.management.service.PremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremisesServiceImpl implements PremisesService {

    @Autowired
    PremisesRepository premisesRepository;

    @Override
    public List<Premises> getAll() {
        return premisesRepository.findAll();
    }

    @Override
    public Premises getPremiseById(Long id) {
        Premises premises=premisesRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Premises", "id", id));
        return premisesRepository.getById(id);
    }

    @Override
    public Premises savePremises(Premises premises) {
        return premisesRepository.save(premises);
    }

    @Override
    public void deletePremisesById(Long id) {
        Premises premises = premisesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Premises", "id", id));
        premisesRepository.deleteById(id);
    }
}

