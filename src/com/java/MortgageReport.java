package com.java;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;//instead of creating object multiple times it is good to create the field on top here

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//New Stuff
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
