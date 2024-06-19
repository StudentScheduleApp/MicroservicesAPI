package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.CustomLesson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomLessonController {

    private static final Logger log = LogManager.getLogger(CustomLessonController.class);
    @Autowired
    private CustomLessonRepository customLessonRepository;

    @GetMapping("${mapping.customLesson.getById}/{id}")
    public ResponseEntity<CustomLesson> getById(@PathVariable("id") long id) {
        log.info("get customLesson with id: " + id);
        return ResponseEntity.ok(customLessonRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.customLesson.getByGroupId}/{id}")
    public ResponseEntity<List<CustomLesson>> getByGroupId(@PathVariable("id") long id) {
        log.info("get customLesson with groupId: " + id);
        return ResponseEntity.ok(customLessonRepository.findByGroupId(id));
    }

    @PostMapping("${mapping.customLesson.save}")
    public ResponseEntity<CustomLesson> save(@RequestBody CustomLesson data) {
        if (data.getName() == null || data.getName().isEmpty()) {
            log.warn("bad request: customLesson name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getName().length() > 255) {
            log.warn("bad request: customLesson name length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getTeacher() != null && data.getTeacher().length() > 255) {
            log.warn("bad request: customLesson teacher length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        CustomLesson d = customLessonRepository.save(data);
        log.info("save customLesson with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.customLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            customLessonRepository.deleteById(id);
            log.info("delete customLesson with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete customLesson with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
