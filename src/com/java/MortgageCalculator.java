package com.java;

public class MortgageCalculator {
    //Mortgage Calculating function - making it easy for reusable
    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;


        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {

        short numberOfPayments = (short) (years * Main.MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / Main.PERCENT / Main.MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }
}
