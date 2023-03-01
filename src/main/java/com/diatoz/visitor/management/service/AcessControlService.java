package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.model.AcessModel;

import java.util.List;

public interface AcessControlService {
    public List<AcessControl> getAll();
    AcessModel  findById(Long acessId);
    Object saveAcessControl(AcessControl acessControl)throws AlreadyExistsException;
    AcessModel deleteById(Long acessId);




}
