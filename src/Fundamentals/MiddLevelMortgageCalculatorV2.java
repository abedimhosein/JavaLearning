package Fundamentals;

import java.text.NumberFormat;
import java.util.Scanner;

public class MiddLevelMortgageCalculatorV2 {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        var consoleReader = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = consoleReader.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float monthlyInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate (0, 30): ");
            var annualInterestRate = consoleReader.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a number greater than 0 and less than or equal 30.");
        }

        int numberOfPayments;
        while (true) {
            System.out.print("Period (or Year) (1, 30): ");
            var years = consoleReader.nextByte();
            if (years > 0 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        var special_value = Math.pow(1 + monthlyInterestRate, numberOfPayments);
        var mortgage = principal * ((monthlyInterestRate * special_value) / (special_value - 1));
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
