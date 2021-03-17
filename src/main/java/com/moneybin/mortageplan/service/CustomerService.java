package com.moneybin.mortageplan.service;

import com.moneybin.mortageplan.entity.Customer;
import com.moneybin.mortageplan.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
