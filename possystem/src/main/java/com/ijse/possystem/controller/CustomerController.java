package com.ijse.possystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.possystem.dto.CustomerDto;
import com.ijse.possystem.service.CustomerService;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    ResponseEntity<?> saveCustomer(@RequestBody CustomerDto dto){
        try{
            CustomerDto customerDto= customerService.saveCustomer(dto);
            return ResponseEntity.status(200).body(customerDto);
        }catch (DataIntegrityViolationException e){
            String duplicateValue=extractDuplicateValue(e.getMessage());
            String errorMsg="Duplicate entry! This user already exists with the value: "+duplicateValue;
            return ResponseEntity.status(404).body(Map.of("error",errorMsg));
        }

    }

    @PutMapping("/customer")
    ResponseEntity<CustomerDto>updateCustomer(@RequestBody CustomerDto dto){
        CustomerDto customerDto=customerService.updateCustomer(dto);
        return customerDto==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(customerDto);

    }
    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }
    @GetMapping("/customer")
    ResponseEntity<List<CustomerDto>> getAllCustomer(){
        List<CustomerDto> dtos= customerService.getAllCustomer();
        return dtos==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(dtos);
    }

    private String extractDuplicateValue (String exceptionMessage){
        return exceptionMessage.substring(exceptionMessage.indexOf("Duplicate entry '")+17,exceptionMessage.lastIndexOf("' for key"));
    }

}
