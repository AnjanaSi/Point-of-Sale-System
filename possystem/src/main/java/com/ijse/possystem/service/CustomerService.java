package com.ijse.possystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.possystem.dto.CustomerDto;

@Service
public interface CustomerService {
    CustomerDto saveCustomer(CustomerDto dto);
    CustomerDto updateCustomer(CustomerDto dto);
    void deleteCustomer(int id);
    List<CustomerDto> getAllCustomer();

}
