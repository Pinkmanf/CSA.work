package com.example.demos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Mapper mapper;

    public void insert(Student student){
        mapper.insert(student);
        log.info("结果:{}",mapper.list());
    }

    public List<Student> select(List<String> SNOs){

        List<Student> student = mapper.select(SNOs);
        log.info("查询结果:{}",student);
        log.info("结果:{}",mapper.list());

        return student;
    }

    public void delete(String SNO){
        mapper.delete(SNO);
        log.info("结果:{}",mapper.list());
    }

    public void update(Student student){
        mapper.update(student);
        log.info("结果:{}",mapper.list());

    }
}
