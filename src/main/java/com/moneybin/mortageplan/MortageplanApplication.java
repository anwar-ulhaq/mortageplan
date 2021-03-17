package com.moneybin.mortageplan;

import com.moneybin.mortageplan.entity.Customer;
import com.moneybin.mortageplan.service.CustomerService;
import com.moneybin.mortageplan.service.FileService;
import com.moneybin.mortageplan.utilities.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MortageplanApplication implements CommandLineRunner {

	@Autowired
	private FileService fileService;
	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(MortageplanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		fileService.populateDatabaseFromFile();

		ArrayList<Customer> customers = customerService.getAllCustomers();
		Printer.printAllCustomers(customers);
	}
}
