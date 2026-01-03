package com.java;

public class Main {
    //Class level
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    //5 lines of main method
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate", 0, 30);
        byte years = (byte) Console.readNumber("Period (Years)",0,30);

        MorgageReport.printMortgage(principal, annualInterest, years);
        MorgageReport.printPaymentSchedule(years, principal, annualInterest);
    }


}
