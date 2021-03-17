package com.moneybin.mortageplan.utilities;

public class Maths {

    public static double positivePower(double base, int power) {

        double result = 1.0;

        if (power == 0)
            return result;

        for (int i = 1; i <= power; i++) {
            result *= base;
        }

        return result;
    }

    public static double power(double base, int power) {

        if (power < 0) {

            if (power == Integer.MIN_VALUE) {

                power = (power + 1) * (-1);
                return 1.0 / (power(base * base, power));
            }

            power = power * (-1);

            return 1.0 / power(base, power);
        }

        double result = 1;

        while (power > 0) {

            if (power % 2 == 0) {
                base = base * base;

            } else {

                result = result * base;
                base = base * base;
            }

            power = power / 2;
        }

        return result;
    }

    public static double fixedMonthlyPayments(double totalLoan, double yearlyInterestPercentage, int years) {

        double monthlyInterestRate = (yearlyInterestPercentage/100) / 12;
        //TODO: Confirm if years could be floating point value.
        int numberOfPayments = years * 12;

        return ( totalLoan * monthlyInterestRate * ( positivePower(  ( 1 + monthlyInterestRate ), numberOfPayments)  ) ) / ( positivePower( ( 1 + monthlyInterestRate ), numberOfPayments) - 1 );
    }

    public static double roundToTwoDecimalPlaces(double value) {

        // Shift radix to two places left, Add 0.5 to round first decimal digit
        double shiftedValue = (value * 100) + 0.5;
        int integralPartOfShiftedValue = (int)shiftedValue;
        return (double) integralPartOfShiftedValue / 100;
    }
}
