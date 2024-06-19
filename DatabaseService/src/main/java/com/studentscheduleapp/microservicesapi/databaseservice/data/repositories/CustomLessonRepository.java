package com.studentscheduleapp.microservicesapi.databaseservice.data.repositories;


import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.CustomLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomLessonRepository extends JpaRepository<CustomLesson, Long> {
    List<CustomLesson> findByGroupId(Long id);

}
