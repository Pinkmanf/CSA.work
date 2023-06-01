package com.example.demos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/student")
@RestController
public class Controller {

    @Autowired
    Service service;

    @PostMapping("/insert")
    public Result insert(@RequestBody Student student){

        service.insert(student);
        return Result.success();
    }

    @GetMapping("/{SNOs}")
    public Result select(@PathVariable List<String> SNOs){
        List<Student> student = service.select(SNOs);


        return Result.success();
    }

    @DeleteMapping("/{SNO}")
    public void delete(@PathVariable String SNO){
        service.delete(SNO);
    }

    @PutMapping
    public void update(@RequestBody Student student){
        service.update(student);
    }
}
