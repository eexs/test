package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.TestEntity;

import java.util.List;

public interface TestService extends IService<TestEntity> {

    List<TestEntity> getAll();

}
