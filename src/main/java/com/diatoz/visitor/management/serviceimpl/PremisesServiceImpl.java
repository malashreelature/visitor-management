package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.model.PremisesModel;
import com.diatoz.visitor.management.model.VisitorLogModel;
import com.diatoz.visitor.management.repository.PremisesRepository;
import com.diatoz.visitor.management.service.PremisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public PremisesModel findById(Long id) {
        PremisesModel model = new PremisesModel();
        try {
            model.setPremises((Premises) premisesRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException("premises with id not found")));
            model.setErrorMessage(" ");
            if (!model.getPremises().getId().equals(id)) {
                throw new EntityNotFoundException("");
            }
        } catch (EntityNotFoundException e) {
            model.setPremises(null);
            model.setErrorMessage(e.getMessage());
        }
        return model;
    }

    @Override
    public PremisesModel deleteById(Long id) {
        PremisesModel model = new PremisesModel();
        try {
            if (!premisesRepository.existsById(id)) {
                throw new EntityNotFoundException(" Premises with id not exists");
            }
            premisesRepository.deleteById(id);

        } catch (EntityNotFoundException e) {
            model.setErrorMessage(e.getMessage());
        }
        return model;

    }

    @Override
    public PremisesModel savePremises(Premises premises) throws AlreadyExistsException {
        PremisesModel model = new PremisesModel();
        try {
            model.setPremises((Premises) premisesRepository.save(premises));
            if (model != null) {
                premisesRepository.save(premises);

            } else {
                throw new AlreadyExistsException(
                        "Premises already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("Premises already exists!!");
        }

        return model;
    }
}
