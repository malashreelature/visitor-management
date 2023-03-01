package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.AcessControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AcessControlRepository extends JpaRepository<AcessControl,Long> {
    static Optional<AcessControl> findById() {
        return findById();
    }


}
