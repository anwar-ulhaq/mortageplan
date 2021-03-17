package com.moneybin.mortageplan.entity;

import com.moneybin.mortageplan.utilities.Maths;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;

@Data
@RequiredArgsConstructor
public class Customer {

    @Id
    public String id;

    @NotBlank
    private final String name;

    @NotNull
    @Positive
    private final double totalLoan;

    @NotNull
    @Positive
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99.9")
    private final double yearlyInterestPercentage;

    @NotNull
    @Positive
    private final int years;

    private double fixedMonthlyPayment = 0;


    @Override
    public String toString() {
        return "" + this.name + " wants to borrow " + this.totalLoan + " € for a period of " + this.years + " years and pay " + Maths.roundToTwoDecimalPlaces(this.fixedMonthlyPayment) + " € each month.";
    }
    // return String.format("%s (age: %d)", name, age);
}
