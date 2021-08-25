package com.example.demo.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
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

    @GetMapping("/cat")
    public void cat() {
        Transaction t = Cat.newTransaction("URL", "/test/cat");
        try {
            Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=${serverIp}");
            Cat.logMetricForCount("metric.key");
            Cat.logMetricForDuration("metric.key", 5);

            yourBusiness();

            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
    }

    private void yourBusiness() {
//        int i = 10 / 0;
        System.out.println("test cat!");
    }

}
