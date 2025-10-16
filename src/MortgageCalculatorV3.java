import java.text.NumberFormat;
import java.util.Scanner;
//CLean Code
public class MortgageCalculatorV3 {
    public static void main(String[] args) {

        int principal = 0;
        byte years = 0;
        float annualInterest =0;

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
            annualInterest = scanner.nextFloat();
            if(annualInterest>0 && annualInterest <= 30)
                break;
            else {
                System.out.println("Enter the Annual Interest value greater 0 and less than or equal to 30");
            }
        }

        while(true) {
            System.out.print("Period (Years) :");
            years = scanner.nextByte();
            if(years >=0 && years <= 30)
                break;
            else {
                System.out.println("Enter the years greater 0 and less than or equal to 30");
            }

        }

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);//New Stuff
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    //Mortgage Calculating function - making it easy for reusable
    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        byte numberOfPayments = (byte)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/ PERCENT/ MONTHS_IN_YEAR;


        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest,numberOfPayments))/
                (Math.pow(1+monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
