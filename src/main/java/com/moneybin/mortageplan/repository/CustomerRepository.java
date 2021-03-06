package com.moneybin.mortageplan.repository;

import com.moneybin.mortageplan.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
