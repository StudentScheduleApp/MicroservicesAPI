package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.OutlineMediaCommentRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.OutlineMediaComment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutlineMediaCommentController {

    private static final Logger log = LogManager.getLogger(OutlineMediaCommentController.class);
    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;

    @GetMapping("${mapping.outlineMediaComment.getById}/{id}")
    public ResponseEntity<OutlineMediaComment> getById(@PathVariable("id") long id) {
        log.info("get outlineMediaComment with id: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.outlineMediaComment.getByOutlineMediaId}/{id}")
    public ResponseEntity<List<OutlineMediaComment>> getByOutlineMediaId(@PathVariable("id") long id) {
        log.info("get outlineMediaComment with outlineMediaId: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findByMediaId(id));
    }

    @PostMapping("${mapping.outlineMediaComment.save}")
    public ResponseEntity<OutlineMediaComment> save(@RequestBody OutlineMediaComment data) {
        if (data.getText() == null || data.getText().isEmpty()) {
            log.warn("bad request: outlineMediaComment text is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getText().length() > 255) {
            log.warn("bad request: outlineMediaComment text length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        OutlineMediaComment d = outlineMediaCommentRepository.save(data);
        log.info("save outlineMediaComment with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.outlineMediaComment.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            outlineMediaCommentRepository.deleteById(id);
            log.info("delete outlineMediaComment with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete outlineMediaComment with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
