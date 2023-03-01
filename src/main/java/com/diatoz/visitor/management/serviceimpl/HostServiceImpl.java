package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.*;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.exception.EntityNotFoundException;
import com.diatoz.visitor.management.model.HostModel;
import com.diatoz.visitor.management.repository.HostRepository;
import com.diatoz.visitor.management.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    @Autowired
    HostRepository hostRepository;

    @Override
    public List<Host> getAll() {
        return hostRepository.findAll();
    }

    @Override
    public HostModel findById(Long hostId) {
        HostModel model1 = new HostModel();
        try {
            model1.setHost((Host) hostRepository.findById(hostId).orElseThrow(() ->
                    new EntityNotFoundException("Host with id not found")));
            model1.setErrorMessage(" ");
            if (!model1.getHost().getHostId().equals(hostId)) {
                throw new EntityNotFoundException("");

            }
        } catch (EntityNotFoundException e) {
            model1.setHost(null);
            model1.setErrorMessage(e.getMessage());
        }
        return model1;
    }



    @Override
    public HostModel saveHost(Host host) throws AlreadyExistsException {
        HostModel model = new HostModel();
        try {
            model.setHost((Host) hostRepository.save(host));
            if (model != null) {
                hostRepository.save(host);

            } else {
                throw new AlreadyExistsException(
                        "host already exists!!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("host already exists!!");
        }
        return model;
    }

    @Override
    public HostModel deleteById(Long hostId) {
        HostModel model1 = new HostModel();
        try {
            if (!hostRepository.existsById(hostId)) {
                throw new EntityNotFoundException(" Visitor with id not exists");
            }
            hostRepository.deleteById(hostId);

        } catch (EntityNotFoundException e) {
            model1.setHost(null);
            model1.setErrorMessage(e.getMessage());
        }
        return model1;

    }

}
