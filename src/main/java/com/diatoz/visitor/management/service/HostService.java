package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Host;

import java.util.List;

public interface HostService {
    public List<Host> getAll();

    Host getHostById(Long hostId);

    Host  saveHost(Host host);

    void deleteHostById(Long hostId );
}
