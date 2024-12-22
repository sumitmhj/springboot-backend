package net.javaguides.com.controller;

import net.javaguides.com.exception.ResourceNotFoundException;
import net.javaguides.com.model.Address;
import net.javaguides.com.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id){
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        return ResponseEntity.ok(address);
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address){
        Address updateAddress = addressRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));
        updateAddress.setStreet(address.getStreet());
        updateAddress.setPostCode(address.getPostCode());
        updateAddress.setState(address.getState());
        updateAddress.setCity(address.getCity());
        updateAddress.setCountry(address.getCountry());

        addressRepository.save(updateAddress);

        return ResponseEntity.ok(updateAddress);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable long id){
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No address found"));
        addressRepository.delete(address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
