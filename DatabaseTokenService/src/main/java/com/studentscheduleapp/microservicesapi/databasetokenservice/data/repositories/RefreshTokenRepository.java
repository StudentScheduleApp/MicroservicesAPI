package com.studentscheduleapp.microservicesapi.databasetokenservice.data.repositories;


import com.studentscheduleapp.microservicesapi.databasetokenservice.data.tablemodels.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

}
