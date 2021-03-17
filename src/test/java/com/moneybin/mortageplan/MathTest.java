package com.moneybin.mortageplan;

import com.moneybin.mortageplan.utilities.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    void integerBaseIntegerPower() {

        int base = 3;
        int power = 2;

        double result = Maths.positivePower(base, power);

        Assertions.assertEquals(9, result);
    }

    @Test
    void doubleBaseIntegerPower() {

        double base = 3.5;
        int power = 2;

        double result = Maths.positivePower(base, power);

        Assertions.assertEquals(12.25, result);
    }

    @Test
    void fixedMonthlyPayment () {

        double totalLoan = 1000000;
        double yearlyInterestPercentage = 12;
        int years = 10;

        double result = Maths.fixedMonthlyPayments(totalLoan, yearlyInterestPercentage, years);

        Assertions.assertEquals(14347.09, Maths.roundToTwoDecimalPlaces(result));
    }
}
