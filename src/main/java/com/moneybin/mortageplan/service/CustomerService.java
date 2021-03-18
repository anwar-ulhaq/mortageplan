package com.moneybin.mortageplan.service;

import com.moneybin.mortageplan.entity.Customer;
import com.moneybin.mortageplan.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }
}
