package com.geekster.Mapping.controller;

import com.geekster.Mapping.model.Student;
import com.geekster.Mapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @GetMapping("/getStudent/{studentId}")
    public List<Student> getAllStudent(@PathVariable Integer studentId){
        return studentService.getAllStudent(studentId);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudentById(@PathVariable Integer studentId){
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping("/updateStudent/{studentId}")
    public String updateStudent(@PathVariable Integer studentId , @RequestBody Student student){
        return studentService.updateStudent(studentId , student);
    }
}