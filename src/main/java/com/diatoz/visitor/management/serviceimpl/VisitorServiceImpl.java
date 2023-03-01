package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.model.VisitorModel;
import com.diatoz.visitor.management.entity.Visitor;
import com.diatoz.visitor.management.repository.VisitorRepository;
import com.diatoz.visitor.management.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    VisitorRepository visitorRepository;


    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }


    @Override
    public VisitorModel findById(Long visitorId) {
        VisitorModel model = new VisitorModel();
        try {
            model.setVisitor((Visitor) visitorRepository.findById(visitorId).orElseThrow(() ->
                    new EntityNotFoundException("Visitor with id not found")));
            model.setErrorMessage(" ");
            if (!model.getVisitor().getVisitorId().equals(visitorId)) {
                throw new EntityNotFoundException("");
            }
        } catch (EntityNotFoundException e) {
            model.setVisitor(null);
            model.setErrorMessage(e.getMessage());
        }
        return model;
    }

    @Override
    public VisitorModel deleteById(Long visitorId) {
        VisitorModel model1 = new VisitorModel();
        try {
            if (!visitorRepository.existsById(visitorId)) {
                throw new EntityNotFoundException(" Visitor with id not exists");
            }
            visitorRepository.deleteById(visitorId);

        } catch (EntityNotFoundException e) {
            model1.setVisitor(null);
            model1.setErrorMessage(e.getMessage());
        }
        return model1;

    }

    @Override
    public VisitorModel saveVisitor(Visitor visitor) throws AlreadyExistsException {
        VisitorModel model = new VisitorModel();
        try {
            model.setVisitor((Visitor) visitorRepository.save(visitor));
            if (model != null) {
                visitorRepository.save(visitor);

            } else {
                throw new AlreadyExistsException(
                        "visitor already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("visitor already exists!!");
        }

        return model;
    }
}



