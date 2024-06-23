package com.studentscheduleapp.microservicesapi.databaseservice.data.repositories;


import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
