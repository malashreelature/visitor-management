package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.Badges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesRepository extends JpaRepository<Badges,Long> {
}
