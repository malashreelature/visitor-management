package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.AccessControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AcessControlRepository extends JpaRepository<AccessControl,Long> {
    static Optional<AccessControl> findById() {
        return findById();
    }


}
