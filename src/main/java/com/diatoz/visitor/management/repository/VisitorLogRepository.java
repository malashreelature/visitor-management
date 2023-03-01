package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.VisitorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorLogRepository extends JpaRepository<VisitorLog,Long> {
}
