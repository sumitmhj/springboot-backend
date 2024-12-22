package net.javaguides.com.controller;

import net.javaguides.com.model.Address;
import net.javaguides.com.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }
}
