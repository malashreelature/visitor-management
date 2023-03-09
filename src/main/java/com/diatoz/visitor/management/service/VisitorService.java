package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Visitor;

import java.util.List;

public interface VisitorService {

    public List<Visitor> getAll();

    Visitor getVisitorById(Long visitorId);

     Visitor saveVisitor(Visitor visitor);

     void deleteVisitorById(Long visitorId);
}
