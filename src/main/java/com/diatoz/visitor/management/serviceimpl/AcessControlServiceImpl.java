package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.model.AcessModel;
import com.diatoz.visitor.management.model.BadgesModel;
import com.diatoz.visitor.management.repository.AcessControlRepository;
import com.diatoz.visitor.management.service.AcessControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessControlServiceImpl implements AcessControlService {

    @Autowired
    AcessControlRepository acessControlRepository;

    @Override
    public List<AcessControl> getAll() {
        return acessControlRepository.findAll();
    }


    @Override
    public AcessModel findById(Long acessId) {
        AcessModel model= new AcessModel();
        try {
            model.setAcessControl((AcessControl)AcessControlRepository.findById().orElseThrow(() ->
                    new EntityNotFoundException("AcessControl with id not found")));
            model.setErrorMessage(" ");
            if (!model.getAcessControl().getAcessId().equals(acessId)) {
                throw new EntityNotFoundException("");
            }
        } catch (EntityNotFoundException e) {
            model.setErrorMessage(e.getMessage());
        }
        return model;
    }



    @Override
    public AcessModel saveAcessControl(AcessControl acessControl) throws AlreadyExistsException {
        AcessModel model= new AcessModel();

        try {
            model.setAcessControl((AcessControl) acessControlRepository.save(acessControl));
            if (model != null) {
                acessControlRepository.save(acessControl);

            } else {
                throw new AlreadyExistsException(
                        "AcessControl already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("AcessControl already exists!!");
        }

        return model;
    }


    @Override
    public AcessModel deleteById(Long acessId) {
        AcessModel model= new AcessModel();
        try {
            if (!acessControlRepository.existsById(acessId)) {
                throw new EntityNotFoundException(" AcessControl with id not exists");
            }
            acessControlRepository.deleteById(acessId);

        } catch (EntityNotFoundException e) {
            model.setErrorMessage(e.getMessage());
        }
        return model;

    }
}



