package com.diatoz.visitor.management.service;

import com.diatoz.visitor.management.entity.Badges;

import java.util.List;

public interface BadgesService {

    public List<Badges> getAll();

    Badges getBadgesById(Long id);

    Badges  saveBadges(Badges badges);

    public void deleteBadgesById(Long id);

}
