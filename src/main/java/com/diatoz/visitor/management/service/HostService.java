package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Host;
import com.diatoz.visitor.management.model.HostModel;
import com.diatoz.visitor.management.exception.AlreadyExistsException;

import java.util.List;

public interface HostService {
    public List<Host> getAll();
    HostModel findById(Long hostId);

    Object  saveHost(Host host)throws AlreadyExistsException;

    HostModel deleteById(Long hostId );
}
