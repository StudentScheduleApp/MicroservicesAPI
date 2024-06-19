package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.OutlineRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.Outline;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutlineController {

    private static final Logger log = LogManager.getLogger(OutlineController.class);
    @Autowired
    private OutlineRepository outlineRepository;

    @GetMapping("${mapping.outline.getById}/{id}")
    public ResponseEntity<Outline> getById(@PathVariable("id") long id) {
        log.info("get outline with id: " + id);
        return ResponseEntity.ok(outlineRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.outline.getBySpecificLessonId}/{id}")
    public ResponseEntity<List<Outline>> getBySpecificLessonId(@PathVariable("id") long id) {
        log.info("get outline with specificLessonId: " + id);
        return ResponseEntity.ok(outlineRepository.findBySpecificLessonId(id));
    }

    @GetMapping("${mapping.outline.getByUserId}/{id}")
    public ResponseEntity<List<Outline>> getByUserId(@PathVariable("id") long id) {
        log.info("get outline with userId: " + id);
        return ResponseEntity.ok(outlineRepository.findByUserId(id));
    }

    @PostMapping("${mapping.outline.save}")
    public ResponseEntity<Outline> save(@RequestBody Outline data) {
        Outline d = outlineRepository.save(data);
        log.info("save outline with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.outline.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            outlineRepository.deleteById(id);
            log.info("delete outline with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete outline with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
