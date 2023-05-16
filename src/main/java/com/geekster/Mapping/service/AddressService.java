package com.geekster.Mapping.service;

import com.geekster.Mapping.model.Address;
import com.geekster.Mapping.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepository iAddressRepository;

    public String addAddress(Address address) {
        if(address!=null){
            iAddressRepository.save(address);
            return "Address added successfully";
        }
        return "Address not added successfully";

    }

    public List<Address> getAllAddress(Integer addressId) {
        if(addressId==null){
            return iAddressRepository.findAll();
        }else{
            List<Address> addressList = new ArrayList<>();
            addressList.add(iAddressRepository.findById(addressId).get());
            return addressList;
        }
    }

    public String deleteAddressById(Integer addressId) {
        Optional<Address> optionalAddress = iAddressRepository.findById(addressId);
        if(optionalAddress.isEmpty()){
            return "Address with id "+addressId + " is not present";
        }else{
            iAddressRepository.deleteById(addressId);
            return "Address with id "+addressId + " deleted successfully";
        }
    }

    public String updateAddress(Integer addressId, Address address) {
        Optional<Address> optionalAddress = iAddressRepository.findById(addressId);
        if(optionalAddress.isEmpty()){
            return "Address with id "+addressId + " is not present";
        }else{
            address.setAddressId(addressId);
            iAddressRepository.save(address);
            return "Address with id "+addressId + " updated successfully";
        }
    }
}
