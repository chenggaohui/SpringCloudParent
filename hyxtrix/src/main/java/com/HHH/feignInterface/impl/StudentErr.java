package com.HHH.feignInterface.impl;

import com.HHH.feignInterface.StudentInterface;
import com.HHH.pojo.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class StudentErr implements StudentInterface {
    @Override
    public Collection<Student> getAll() {
        return null;
    }

    @Override
    public int index() {
        return -1;
    }
}
