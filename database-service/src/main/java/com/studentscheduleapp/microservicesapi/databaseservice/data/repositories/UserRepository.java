package com.studentscheduleapp.microservicesapi.databaseservice.data.repositories;

import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
