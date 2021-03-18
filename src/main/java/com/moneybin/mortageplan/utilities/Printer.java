package com.moneybin.mortageplan.utilities;

import com.moneybin.mortageplan.entity.Customer;

import java.util.List;

public class Printer {

    public static void printAllCustomers(List<Customer> customers) {

        for (int number = 0; number < customers.size(); number++) {
            System.out.println("****************************************************************************************************");
            System.out.println("Prospect " + (number + 1) + ": " + customers.get(number));
            System.out.println("****************************************************************************************************");

        }
    }
}
