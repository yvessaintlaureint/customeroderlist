package com.odp297.demo.repository;

import com.odp297.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {
    // You can define custom queries here if needed
}
