package com.basmaonlinestore.usersserver.services;

import com.basmaonlinestore.usersserver.models.Address;
import com.basmaonlinestore.usersserver.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
            this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses(){
        try {
            return addressRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Address getAddress(long id){
        try {
            return addressRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Address addAddress(Address address){
        try {
            return addressRepository.save(address);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Address updateAddress(Address address){
        try {
            return addressRepository.save(address);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteAddress(Long id){
        try {
            addressRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return false;
        }
    }
}
