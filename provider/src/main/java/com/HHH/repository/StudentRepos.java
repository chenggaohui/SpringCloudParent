package com.HHH.repository;

import com.HHH.pojo.Student;

import java.util.Collection;

public interface StudentRepos {
    public Collection<Student> getAll();
    public Student getByID(int ID);
    public void insert(Student student);
    public void delete(int ID);
}
