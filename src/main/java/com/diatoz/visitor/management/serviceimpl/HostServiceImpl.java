package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.entity.*;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.repository.HostRepository;
import com.diatoz.visitor.management.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Host getHostById(Long hostId) {
        Host host = hostRepository.findById(hostId).orElseThrow(() ->
                new ResourceNotFoundException("Host", "id", hostId));
        return hostRepository.getById(hostId);
    }



    @Override
    public Host saveHost(Host host){
        return hostRepository.save(host);

    }


    @Override
    public void deleteHostById(Long userId) {
        Host host = hostRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Host", "id", userId));
        hostRepository.deleteById(userId);
    }
}


