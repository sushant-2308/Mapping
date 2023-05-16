package com.geekster.Mapping.service;

import com.geekster.Mapping.model.Course;
import com.geekster.Mapping.model.Student;
import com.geekster.Mapping.repository.ICourseRepository;
import com.geekster.Mapping.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    ICourseRepository iCourseRepository;

    @Autowired
    IStudentRepository iStudentRepository;

    public String addCourse(Course course) {
        if(course!=null){
            List<Student> studentList = course.getStudentList();
            List<Student> studentList1 = new ArrayList<>();
            for(Student student : studentList){
                Optional<Student> student1 = iStudentRepository.findById(student.getStudentId());
                if(student1.isPresent()){
                    studentList1.add(student1.get());

                }else{
                    throw new IllegalStateException("Student id " +student.getStudentId() + " not present");
                }
            }
            course.setStudentList(studentList1);
            iCourseRepository.save(course);
            return "Course added successfully";


        }
        return "Course not added successfully";
    }

    public List<Course> getAllCourse(Integer courseId) {
        if(courseId==null){
            return iCourseRepository.findAll();
        }else{
            List<Course> courseList = new ArrayList<>();
            courseList.add(iCourseRepository.findById(courseId).get());
            return courseList;
        }
    }

    public String deleteCourseById(Integer courseId) {
        Optional<Course> optionalcourse = iCourseRepository.findById(courseId);
        if(optionalcourse.isEmpty()){
            return "Course with id "+courseId + " is not present";
        }else{
            iCourseRepository.deleteById(courseId);
            return "Course with id "+courseId + " deleted successfully";
        }
    }

    public String updateCourse(Integer courseId, Course course) {
        Optional<Course> optionalcourse = iCourseRepository.findById(courseId);

        if(optionalcourse.isEmpty()){
            return "Course with id "+courseId + " is not present";
        }else{
            List<Student> newStudentList = course.getStudentList();
            List<Student> listStudent = new ArrayList<>();

            for(Student student : newStudentList){
                Optional<Student> student1 = iStudentRepository.findById(student.getStudentId());
                if(student1.isPresent()){
                    listStudent.add(student1.get());

                }else{
                    throw new IllegalStateException("Student id " +student.getStudentId() + " not present");
                }
            }
            course.setStudentList(listStudent);
            course.setCourseId(courseId);
            iCourseRepository.save(course);
            return "Course with id "+courseId + " updated successfully";
        }
    }
}