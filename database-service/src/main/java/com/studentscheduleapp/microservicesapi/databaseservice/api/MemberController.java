package com.studentscheduleapp.microservicesapi.databaseservice.api;

import com.studentscheduleapp.microservicesapi.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels.Member;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private static final Logger log = LogManager.getLogger(MemberController.class);
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("${mapping.member.getById}/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") long id) {
        log.info("get member with id: " + id);
        return ResponseEntity.ok(memberRepository.findById(id).orElse(null));
    }

    @GetMapping("${mapping.member.getByGroupId}/{id}")
    public ResponseEntity<List<Member>> getByGroupId(@PathVariable("id") long id) {
        log.info("get member with groupId: " + id);
        return ResponseEntity.ok(memberRepository.findByGroupId(id));
    }

    @GetMapping("${mapping.member.getByUserId}/{id}")
    public ResponseEntity<List<Member>> getByUserId(@PathVariable("id") long id) {
        log.info("get member with userId: " + id);
        return ResponseEntity.ok(memberRepository.findByUserId(id));
    }

    @PostMapping("${mapping.member.save}")
    public ResponseEntity<Member> save(@RequestBody Member data) {
        Member d = memberRepository.save(data);
        log.info("save member with id: " + d.getId());
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("${mapping.member.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        try {
            memberRepository.deleteById(id);
            log.info("delete member with id: " + id);
        } catch (EmptyResultDataAccessException e) {
            log.warn("delete member with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
