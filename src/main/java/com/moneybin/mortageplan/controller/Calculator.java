package com.moneybin.mortageplan.controller;

import com.moneybin.mortageplan.entity.Customer;
import com.moneybin.mortageplan.service.CustomerService;
import com.moneybin.mortageplan.utilities.Maths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Calculator {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/calculator")
    public String calculatorForm(Model model) {

        Customer customer = new Customer("", 0, 0, 0);
        model.addAttribute("customer", customer);
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "calculator";
        }
        double fixedMonthlyPayment = Maths.fixedMonthlyPayments(customer.getTotalLoan(), customer.getYearlyInterestPercentage(), customer.getYears());
        customer.setFixedMonthlyPayment(fixedMonthlyPayment);
        return "result";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, Model model) {

        customerService.addCustomer(customer);
        return "index";
    }
}
