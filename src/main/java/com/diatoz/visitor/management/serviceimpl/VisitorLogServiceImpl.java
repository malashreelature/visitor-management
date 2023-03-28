package com.diatoz.visitor.management.serviceimpl;
import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.exception.ResourceNotFoundException;
import com.diatoz.visitor.management.repository.VisitorLogRepository;
import com.diatoz.visitor.management.service.VisitorLogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public VisitorLog getVisitorLogById(Long id) {
        VisitorLog visitor = visitorLogRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("VisitorLog", "visitorId", id));
        return visitorLogRepository.getById(id);
    }



    @Override
    public VisitorLog saveVisitorLog(VisitorLog visitorLog) {
        return visitorLogRepository.save(visitorLog);
}



    @Override
    public void deleteVisitorLogById(Long id) {
        VisitorLog visitor = visitorLogRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("VisitorLog", "Id", id));
        visitorLogRepository.deleteById(id);
    }
}




