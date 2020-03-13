package com.HHH.controller;

import com.HHH.feignInterface.StudentInterface;
import com.HHH.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/feign")
public class StudentController {

    @Autowired
    StudentInterface studentInterface;

    @GetMapping("/getAll")
    public Collection<Student> getAll(){
        return studentInterface.getAll();
    }

    @GetMapping("/index")
    public int index(){
        return studentInterface.index();
    }
}
