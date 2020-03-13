package com.HHH.impl;

import com.HHH.pojo.Student;
import com.HHH.repository.StudentRepos;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentImpl  implements StudentRepos {
    private static Map<Integer,Student> map;
    static {
        map=new HashMap<>();
        map.put(1,new Student(1,"张三",15));
        map.put(2,new Student(2,"李四",17));
        map.put(3,new Student(3,"王五",25));
    }
    @Override
    public Collection<Student> getAll() {
        return map.values();
    }

    @Override
    public Student getByID(int ID) {
        return map.get(ID);
    }

    @Override
    public void insert(Student student) {
        map.put(student.getID(),student);
    }

    @Override
    public void delete(int ID) {
    map.remove(ID);
    }
}
