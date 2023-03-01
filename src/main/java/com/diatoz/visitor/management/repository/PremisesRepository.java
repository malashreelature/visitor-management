package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.Premises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremisesRepository extends JpaRepository<Premises,Long> {
}
