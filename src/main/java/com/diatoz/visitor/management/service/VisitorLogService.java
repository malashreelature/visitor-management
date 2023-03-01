package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.VisitorLog;
import com.diatoz.visitor.management.model.VisitorLogModel;
import com.diatoz.visitor.management.exception.AlreadyExistsException;

import java.util.List;

public interface VisitorLogService {

    public List<VisitorLog> getAll();
    VisitorLogModel findById(Long id);

    Object  saveVisitorLog(VisitorLog visitorLog)throws AlreadyExistsException;

    VisitorLogModel deleteById(Long id);
}

