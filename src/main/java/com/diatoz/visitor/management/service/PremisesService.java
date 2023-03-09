package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Premises;

import java.util.List;

public interface PremisesService {
    public List<Premises> getAll();

    Premises getPremiseById(Long id);

    Premises  savePremises(Premises premises);

    public void deletePremisesById(Long  id);
}