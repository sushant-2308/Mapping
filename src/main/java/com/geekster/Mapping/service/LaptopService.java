package com.geekster.Mapping.service;

import com.geekster.Mapping.model.Laptop;
import com.geekster.Mapping.model.Student;
import com.geekster.Mapping.repository.ILaptopRepository;
import com.geekster.Mapping.repository.IStudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepository iLaptopRepository;

    @Autowired
    IStudentRepository iStudentRepository;


    public String addLaptop(Laptop laptop) {
        if(laptop!=null){
            Student student = laptop.getStudent();
            Optional<Student> optionalStudent = iStudentRepository.findById(student.getStudentId());
            if(optionalStudent.isPresent()){
                iLaptopRepository.save(laptop);
                return "Laptop added successfully";

            }else{
                return "Enter valid details";
            }

        }

        return "Laptop not added successfully";

    }

    public List<Laptop> getAllLaptop(Integer laptopId) {
        if(laptopId==null){
            return iLaptopRepository.findAll();
        }else{
            List<Laptop> laptopList = new ArrayList<>();
            laptopList.add(iLaptopRepository.findById(laptopId).get());
            return laptopList;
        }
    }

    public String deleteLaptopById(Integer laptopId) {
        Optional<Laptop> optionalLaptop= iLaptopRepository.findById(laptopId);
        if(optionalLaptop.isEmpty()){
            return "Laptop with id "+laptopId + " is not present";
        }else{
            iLaptopRepository.deleteById(laptopId);
            return "Laptop with id "+laptopId + " deleted successfully";
        }
    }

    public String updateLaptop(Integer laptopId, Laptop laptop) {
        Optional<Laptop> optionalLaptop = iLaptopRepository.findById(laptopId);
        Student student = laptop.getStudent();
        if(optionalLaptop.isEmpty()){
            return "Laptop with id "+laptopId + " is not present";
        }else{
            Optional<Student> student1 = iStudentRepository.findById(student.getStudentId());
            laptop.setStudent(student1.get());
            laptop.setLaptopId(laptopId);
            iLaptopRepository.save(laptop);
            return "Laptop with id "+laptopId + " updated successfully";
        }
    }
}