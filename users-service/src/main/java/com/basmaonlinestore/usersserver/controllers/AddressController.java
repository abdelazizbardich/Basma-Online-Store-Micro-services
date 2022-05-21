package com.basmaonlinestore.usersserver.controllers;

import com.basmaonlinestore.usersserver.models.Address;
import com.basmaonlinestore.usersserver.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public ResponseEntity<List<Address>> getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @GetMapping("/{idAddress}")
    public ResponseEntity<Address> getAddress(@PathVariable(name = "idAddress") Long id){
        return ResponseEntity.status(200).body(addressService.getAddress(id));
    }

    @PostMapping("")
    public  ResponseEntity<Address> addAddress(@RequestBody Address user){
        return ResponseEntity.status(200).body(addressService.addAddress(user));
    }

    @PutMapping("")
    public  ResponseEntity<Address> updateAddress(@RequestBody Address user){
        return ResponseEntity.status(200).body(addressService.updateAddress(user));
    }

    @DeleteMapping("")
    public ResponseEntity deleteAddress(@RequestBody Address user){
        return ResponseEntity.status(200).body(addressService.deleteAddress(user.getIdAddress()));
    }
}
