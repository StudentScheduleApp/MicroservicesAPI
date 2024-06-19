package com.studentscheduleapp.microservicesapi.databaseservice.data.repositories;


import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.OutlineMediaComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutlineMediaCommentRepository extends JpaRepository<OutlineMediaComment, Long> {

    List<OutlineMediaComment> findByMediaId(long id);
}
