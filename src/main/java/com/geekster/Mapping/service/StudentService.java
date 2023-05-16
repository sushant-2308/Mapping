package com.geekster.Mapping.service;

import com.geekster.Mapping.model.Student;
import com.geekster.Mapping.repository.IStudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepository iStudentRepository;

    public String addStudent(Student student) {
        if(student!=null){
            iStudentRepository.save(student);
            return "Student added successfully";
        }
        return "Student not added successfully";


    }

    public List<Student> getAllStudent(Integer studentId) {
        if(studentId==null){
            return iStudentRepository.findAll();
        }else{
            List<Student> studentList = new ArrayList<>();
            studentList.add(iStudentRepository.findById(studentId).get());
            return studentList;
        }
    }

    public String deleteStudentById(Integer studentId) {
        Optional<Student> optionalStudent = iStudentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
            return "Student with id "+studentId + " is not present";
        }else{
            iStudentRepository.deleteById(studentId);
            return "Student with id "+studentId + " deleted successfully";
        }
    }

    public String updateStudent(Integer studentId , Student student) {
        Optional<Student> optionalStudent = iStudentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
            return "Student with id "+studentId + " is not present";
        }else{
            student.setStudentId(studentId);
            iStudentRepository.save(student);
            return "Student with id "+studentId + " updated successfully";
        }
    }
}