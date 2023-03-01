package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Badges;
import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.exception.AlreadyExistsException;
import com.diatoz.visitor.management.model.BadgesModel;
import com.diatoz.visitor.management.model.UserModel;

import java.util.List;

public interface BadgesService {

    public List<Badges> getAll();
    BadgesModel findById(Long id);

    Object  saveBadges(Badges badges)throws AlreadyExistsException;

    BadgesModel deleteById(Long id);

}
