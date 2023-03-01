package com.diatoz.visitor.management.serviceimpl;


import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.model.VisitorLogModel;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.repository.VisitorLogRepository;
import com.diatoz.visitor.management.service.VisitorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorLogServiceImpl implements VisitorLogService {

    @Autowired
    VisitorLogRepository visitorLogRepository;

    @Override
    public List<VisitorLog> getAll() {
        return visitorLogRepository.findAll();
    }


    @Override
    public VisitorLogModel findById(Long id) {
        VisitorLogModel model = new VisitorLogModel();
        try {
            model.setVl((VisitorLog) visitorLogRepository.findById(id).orElseThrow(() ->
                    new EntityNotFoundException("VisitorLog with id not found")));
            model.setErrorMessage(" ");
            if (!model.getVl().getId().equals(id)) {
                throw new EntityNotFoundException("");
            }
        } catch (EntityNotFoundException e) {
            model.setVl(null);
            model.setErrorMessage(e.getMessage());
        }
        return model;
    }

    @Override
    public VisitorLogModel deleteById(Long id) {
        VisitorLogModel model1 = new VisitorLogModel();
        try {
            if (!visitorLogRepository.existsById(id)) {
                throw new EntityNotFoundException(" VisitorLog with id not exists");
            }
            visitorLogRepository.deleteById(id);

        } catch (EntityNotFoundException e) {
            model1.setVl(null);
            model1.setErrorMessage(e.getMessage());
        }
        return model1;

    }

    @Override
    public VisitorLogModel saveVisitorLog(VisitorLog visitorLog) throws AlreadyExistsException {
        VisitorLogModel model = new VisitorLogModel();
        try {
            model.setVl((VisitorLog) visitorLogRepository.save(visitorLog));
            if (model != null) {
                visitorLogRepository.save(visitorLog);

            } else {
                throw new AlreadyExistsException(
                        "visitorLog already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("visitorLog already exists!!");
        }

        return model;
    }
}
