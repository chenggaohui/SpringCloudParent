package com.HHH.controller;

import com.HHH.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestTempletController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getAll")
    public Collection<Student> getAll() {
        return restTemplate.getForEntity("http://localhost:8010/student/getAll",Collection.class).getBody();
    }

    @GetMapping("/getByID/{id}")
    public Student getByID(@PathVariable("id") int id){
        return restTemplate.getForEntity("http://localhost:8010/student/getByID/"+id,Student.class).getBody();
    }
}
