package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.model.VisitorModel;
import com.diatoz.visitor.management.entity.Visitor;

import java.util.List;

public interface VisitorService {

    public List<Visitor> getAll();
    VisitorModel findById(Long visitorId);

    Object  saveVisitor(Visitor visitor)throws AlreadyExistsException;

    VisitorModel deleteById(Long visitorId);


}
