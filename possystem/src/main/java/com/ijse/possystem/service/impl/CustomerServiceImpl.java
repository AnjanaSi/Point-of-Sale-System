package com.ijse.possystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.possystem.dto.CustomerDto;
import com.ijse.possystem.entity.Customer;
import com.ijse.possystem.repository.CustomerRepository;
import com.ijse.possystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public CustomerDto saveCustomer(CustomerDto dto) {
        Customer customer = repository.save(mapper.convertValue(dto, Customer.class));
        return mapper.convertValue(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto dto) {

        Customer customer = mapper.convertValue(dto, Customer.class);
        return mapper.convertValue(repository.save(customer), CustomerDto.class);

    }

    @Override
    public void deleteCustomer(int id) {

        repository.delete(repository.findById(id).orElse(null));
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = repository.findAll();
        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer eachCustomer : customers) {
            CustomerDto customerDto = mapper.convertValue(eachCustomer, CustomerDto.class);
            dtos.add(customerDto);
        }
        return dtos;
    }

}
