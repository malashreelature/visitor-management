package com.diatoz.visitor.management.service;
import com.diatoz.visitor.management.entity.AccessControl;
import java.util.List;

public interface AccessControlService {

    public List<AccessControl> getAll();

    AccessControl getAccessById(Long accessId);

    AccessControl saveAcessControl(AccessControl acessControl);

    void deleteAccessById(Long accessId);
}
