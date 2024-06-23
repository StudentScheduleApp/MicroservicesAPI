package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("${mapping.user.getById}/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        log.info("get user with id: " + id);
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.user.getByEmail}/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        log.info("get user with email: " + email);
        return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
    }

    @PostMapping("${mapping.user.save}")
    public ResponseEntity<User> save(@RequestBody User data) {
        if (data.getEmail() == null || data.getEmail().isEmpty()) {
            log.warn("bad request: user email is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getPassword() == null || data.getPassword().isEmpty()) {
            log.warn("bad request: user password is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getFirstName() == null || data.getFirstName().isEmpty()) {
            log.warn("bad request: user firstName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getLastName() == null || data.getLastName().isEmpty()) {
            log.warn("bad request: user lastName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getEmail().length() > 255) {
            log.warn("bad request: user email length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getPassword().length() > 255) {
            log.warn("bad request: user password length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getFirstName().length() > 255) {
            log.warn("bad request: user firstName length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getLastName().length() > 255) {
            log.warn("bad request: user lastName length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (data.getAvaUrl() != null && data.getAvaUrl().length() > 255) {
            log.warn("bad request: user avaUrl length > 255");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User d = userRepository.save(data);
        log.info("save user with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.user.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            userRepository.deleteById(id);
            log.info("delete user with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete user with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
