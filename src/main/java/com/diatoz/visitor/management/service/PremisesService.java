package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Premises;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.model.PremisesModel;

import java.util.List;

public interface PremisesService {
    public List<Premises> getAll();
    PremisesModel findById(Long id);

    Object  savePremises(Premises premises)throws AlreadyExistsException;

    PremisesModel deleteById(Long  id);
}