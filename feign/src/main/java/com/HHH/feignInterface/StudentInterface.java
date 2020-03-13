package com.HHH.feignInterface;

import com.HHH.feignInterface.impl.StudentErr;
import com.HHH.pojo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = StudentErr.class)
public interface StudentInterface {

    @GetMapping("/student/getAll")
    public Collection<Student> getAll();

    @GetMapping("student/index")
    public int index();
}
