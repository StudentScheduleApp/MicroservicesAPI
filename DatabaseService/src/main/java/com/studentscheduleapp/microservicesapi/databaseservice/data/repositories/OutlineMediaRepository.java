package com.studentscheduleapp.microservicesapi.databaseservice.data.repositories;


import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.OutlineMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutlineMediaRepository extends JpaRepository<OutlineMedia, Long> {

    List<OutlineMedia> findByOutlineId(long id);
}
