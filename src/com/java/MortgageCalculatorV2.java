package com.java;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculatorV2 {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        /*
        * Input Validation check
        * */

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal>=1000 && principal <= 1_000_000) {
                break;
            }
            else {
                System.out.println("Enter the value greater or equal to 1K and less than or equal to 1M");
            }
        }

        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest>0 && annualInterest <= 30) {
                monthlyInterest = annualInterest/ PERCENT/ MONTHS_IN_YEAR;
                break;
            }
            else {
                System.out.println("Enter the Annual Interest value greater 0 and less than or equal to 30");
            }
        }

        while(true) {
            System.out.print("Period (Years) :");
            byte years = scanner.nextByte();
            if(years >=0 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            else {
                System.out.println("Enter the years greater 0 and less than or equal to 30");
            }

        }

        //Mortgage Calculating Formula Application
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments))/
                (Math.pow(1+monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//New Stuff
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
