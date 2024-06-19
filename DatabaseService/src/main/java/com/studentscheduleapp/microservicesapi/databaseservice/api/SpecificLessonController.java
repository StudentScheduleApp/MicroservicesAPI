package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.SpecificLessonRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.SpecificLesson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecificLessonController {

    private static final Logger log = LogManager.getLogger(SpecificLessonController.class);
    @Autowired
    private SpecificLessonRepository specificLessonRepository;

    @GetMapping("${mapping.specificLesson.getById}/{id}")
    public ResponseEntity<SpecificLesson> getById(@PathVariable("id") long id) {
        log.info("get specificLesson with id: " + id);
        return ResponseEntity.ok(specificLessonRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.specificLesson.getByGroupId}/{id}")
    public ResponseEntity<List<SpecificLesson>> getByGroupId(@PathVariable("id") long id) {
        log.info("get specificLesson with groupId: " + id);
        return ResponseEntity.ok(specificLessonRepository.findByGroupId(id));
    }

    @PostMapping("${mapping.specificLesson.save}")
    public ResponseEntity<SpecificLesson> save(@RequestBody SpecificLesson data) {
        if (data.getComment() != null && data.getComment().length() > 255) {
            log.warn("bad request: specificLesson comment length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        SpecificLesson d = specificLessonRepository.save(data);
        log.info("save specificLesson with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.specificLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            specificLessonRepository.deleteById(id);
            log.info("delete specificLesson with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete specificLesson with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
