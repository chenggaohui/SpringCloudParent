package com.HHH.controller;

import com.HHH.pojo.Student;
import com.HHH.repository.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepos studentRepos;

    @Value("${server.port}")
    private int port;

    @GetMapping("/getAll")
    public Collection<Student> getAll(){
        return studentRepos.getAll();
    }

    @GetMapping("/getByID/{id}")
    public Student getByID(@PathVariable("id") int id){
        return studentRepos.getByID(id);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Student student){
        studentRepos.insert(student);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        studentRepos.delete(id);
    }

    @GetMapping("/index")
    public int index(){
        return this.port;
    }
}
