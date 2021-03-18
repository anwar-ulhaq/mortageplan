package com.moneybin.mortageplan.service;

import com.moneybin.mortageplan.entity.Customer;
import com.moneybin.mortageplan.repository.FileRepository;
import com.moneybin.mortageplan.utilities.Maths;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    private CustomerService customerService;

    public void populateDatabaseFromFile() {

        // remove previously entries from database
        //customerService.deleteAllCustomers();

        List<Customer> customers = FileRepository.readFile();

        for (Customer customer : customers
        ) {
            double fixedMonthlyPayment = Maths.fixedMonthlyPayments(customer.getTotalLoan(), customer.getYearlyInterestPercentage(), customer.getYears());
            customer.setFixedMonthlyPayment(fixedMonthlyPayment);

            customerService.addCustomer(customer);
        }
    }
}
