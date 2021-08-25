package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/getById")
    public ResponseEntity getById(Long id) {
        TestEntity testEntity = testService.getById(id);
        return ResponseEntity.ok(testEntity);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        List<TestEntity> testEntityList = testService.getAll();
        return ResponseEntity.ok(testEntityList);
    }

}
