package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.LessonTemplateRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.LessonTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonTemplateController {

    private static final Logger log = LogManager.getLogger(LessonTemplateController.class);
    @Autowired
    private LessonTemplateRepository lessonTemplateRepository;

    @GetMapping("${mapping.lessonTemplate.getById}/{id}")
    public ResponseEntity<LessonTemplate> getById(@PathVariable("id") long id) {
        log.info("get lessonTemplate with id: " + id);
        return ResponseEntity.ok(lessonTemplateRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.lessonTemplate.getByScheduleTemplateId}/{id}")
    public ResponseEntity<List<LessonTemplate>> getByScheduleTemplateId(@PathVariable("id") long id) {
        log.info("get lessonTemplate with scheduleTemplateId: " + id);
        return ResponseEntity.ok(lessonTemplateRepository.findByScheduleTemplateId(id));
    }

    @PostMapping("${mapping.lessonTemplate.save}")
    public ResponseEntity<LessonTemplate> save(@RequestBody LessonTemplate data) {
        if (data.getComment() != null && data.getComment().length() > 255) {
            log.warn("bad request: lessonTemplate comment length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LessonTemplate d = lessonTemplateRepository.save(data);
        log.info("save lessonTemplate with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.lessonTemplate.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            lessonTemplateRepository.deleteById(id);
            log.info("delete lessonTemplate with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete lessonTemplate with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
