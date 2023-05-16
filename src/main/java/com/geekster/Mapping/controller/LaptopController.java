package com.geekster.Mapping.controller;

import com.geekster.Mapping.model.Laptop;
import com.geekster.Mapping.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping("/addLaptop")
    public String addLaptop(@RequestBody Laptop laptop){

        return laptopService.addLaptop(laptop);
    }

    @GetMapping("/getLaptop")
    public List<Laptop> getAllLaptop(@PathVariable Integer laptopId){
        return laptopService.getAllLaptop(laptopId);
    }

    @DeleteMapping("/deleteLaptop/{laptopId}")
    public String deleteLaptopById(@PathVariable Integer laptopId){
        return laptopService.deleteLaptopById(laptopId);
    }

    @PutMapping("/updateLaptop/{LaptopId}")
    public String updateLaptop(@PathVariable Integer LaptopId , @RequestBody Laptop laptop){
        return laptopService.updateLaptop(LaptopId , laptop);
    }

}