package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.ScheduleTemplateRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.ScheduleTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleTemplateController {

    private static final Logger log = LogManager.getLogger(ScheduleTemplateController.class);
    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;

    @GetMapping("${mapping.scheduleTemplate.getById}/{id}")
    public ResponseEntity<ScheduleTemplate> getById(@PathVariable("id") long id) {
        log.info("get scheduleTemplate with id: " + id);
        return ResponseEntity.ok(scheduleTemplateRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.scheduleTemplate.getByGroupId}/{id}")
    public ResponseEntity<List<ScheduleTemplate>> getByGroupId(@PathVariable("id") long id) {
        log.info("get scheduleTemplate with groupId: " + id);
        return ResponseEntity.ok(scheduleTemplateRepository.findByGroupId(id));
    }

    @PostMapping("${mapping.scheduleTemplate.save}")
    public ResponseEntity<ScheduleTemplate> save(@RequestBody ScheduleTemplate data) {
        if (data.getName() == null || data.getName().isEmpty()) {
            log.warn("bad request: scheduleTemplate name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getName().length() > 255) {
            log.warn("bad request: scheduleTemplate name length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getComment() != null && data.getComment().length() > 255) {
            log.warn("bad request: scheduleTemplate comment length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        ScheduleTemplate d = scheduleTemplateRepository.save(data);
        log.info("save scheduleTemplate with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.scheduleTemplate.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            scheduleTemplateRepository.deleteById(id);
            log.info("delete scheduleTemplate with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete scheduleTemplate with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
