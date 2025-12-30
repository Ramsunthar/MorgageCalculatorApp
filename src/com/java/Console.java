package com.java;

import java.util.Scanner;

/**
 * I moved this method to a new class to reduce the code clutter in the main class.
 * This does one job, which is to read user input. so it has nothing to do with the other part of the code in the main class
 **/
public class Console {

    private static Scanner scanner = new Scanner(System.in);

    //in case of getting inputs without range. - Overloaded method
    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    //Reading input and check the value  - common pattern function
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Enter the value between" + min + "and " + max);
            }
        }
        return value;
    }
}

