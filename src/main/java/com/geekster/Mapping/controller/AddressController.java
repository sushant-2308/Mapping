package com.geekster.Mapping.controller;

import com.geekster.Mapping.model.Address;
import com.geekster.Mapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/addAddress")
    public String addAddress(@RequestBody Address address){

        return addressService.addAddress(address);
    }

    @GetMapping("/getAddress")
    public List<Address> getAllAddress(@PathVariable Integer addressId){
        return addressService.getAllAddress(addressId);
    }

    @DeleteMapping("/deleteAddress/{addressId}")
    public String deleteAddressById(@PathVariable Integer addressId){
        return addressService.deleteAddressById(addressId);
    }

    @PutMapping("/updateAddress/{addressId}")
    public String updateAddress(@PathVariable Integer addressId , @RequestBody Address address){
        return addressService.updateAddress(addressId , address);
    }
}