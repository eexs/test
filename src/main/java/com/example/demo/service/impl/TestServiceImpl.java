package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.TestEntity;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements TestService {

    @Override
    public List<TestEntity> getAll() {
        return baseMapper.selectAll();
    }

}
