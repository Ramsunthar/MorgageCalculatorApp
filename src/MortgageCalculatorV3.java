import java.text.NumberFormat;
import java.util.Scanner;
/*
* CLEAN CODE
* 1. extracting method and make it a reusable unit
* 2. refactoring the code by finding repetitive patterns in the whole code and make it is a template function.
* */
public class  MortgageCalculatorV3 {
    public static void main(String[] args) {

        int principal = (int)readNumber("Principal ($1K - $1M)", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate", 0, 30);
        short years = (short) readNumber("Period (Years)",0,30);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//New Stuff
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    //Reading input and check the value  - common pattern function
    public static double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt+": ");
            value = scanner.nextDouble();
            if(value>=min && value <= max) {
                break;
            }
            else {
                System.out.println("Enter the value between" + min + "and "+ max);
            }
        }
        return value;
    }

    //Mortgage Calculating function - making it easy for reusable
    public static double calculateMortgage(int principal, float annualInterest, short years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/ PERCENT/ MONTHS_IN_YEAR;


        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments))/
                (Math.pow(1+monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
