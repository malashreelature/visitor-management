package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.VisitorLog;

import java.util.List;

public interface VisitorLogService {

    public List<VisitorLog> getAll();

    VisitorLog getVisitorLogById(Long id);

    VisitorLog saveVisitorLog(VisitorLog visitorLog);

    void deleteVisitorLogById(Long id);
}

