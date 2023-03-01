package com.diatoz.visitor.management.repository;

import com.diatoz.visitor.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<User,Long> {

}
