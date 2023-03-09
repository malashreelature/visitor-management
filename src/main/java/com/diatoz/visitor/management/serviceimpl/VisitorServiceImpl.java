package com.diatoz.visitor.management.serviceimpl;

import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.entity.Visitor;
import com.diatoz.visitor.management.repository.VisitorRepository;
import com.diatoz.visitor.management.service.VisitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;



    @Override
    public List<Visitor> getAll() {
        return visitorRepository.findAll();
    }



    @Override
    public Visitor getVisitorById(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow(() ->
                new ResourceNotFoundException("Visitor", "visitorId", visitorId));
        return visitorRepository.getById(visitorId);
    }



    @Override
    public Visitor saveVisitor(Visitor visitor){
        return visitorRepository.save(visitor);

    }


     @Override
    public void deleteVisitorById(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow(() ->
                new ResourceNotFoundException("Visitor", "visitorId", visitorId));
        visitorRepository.deleteById(visitorId);
    }
}



