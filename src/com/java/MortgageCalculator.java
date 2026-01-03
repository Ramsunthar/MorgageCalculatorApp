package com.java;
//Purely response for calculation
public class MortgageCalculator {
    //Class level
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest,  byte years) {
        this.principal = principal;
        this.years = years;
        this.annualInterest = annualInterest;
    }

    //Mortgage Calculating function - making it easy for reusable
    public double calculateMortgage() {

        short numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();


        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {

        short numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public byte getYears() {
        return years;
    }
    //private as these are implementation details.
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}
