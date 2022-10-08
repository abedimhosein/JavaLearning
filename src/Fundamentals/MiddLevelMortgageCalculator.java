package Fundamentals;

import java.text.NumberFormat;
import java.util.Scanner;

public class MiddLevelMortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        var scanner = new Scanner(System.in);

        Integer principal = null;
        do {
            if (principal != null)
                System.out.println("Enter a number between 1,000 and 1,000,000.");

            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
        } while (!(principal >= 1_000 && principal <= 1_000_000));

        Float annualInterestRate = null;
        do {
            if (annualInterestRate != null)
                System.out.println("Enter a number greater than 0 and less than or equal 30.");
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
        } while (!(annualInterestRate > 0 && annualInterestRate <= 30));
        var monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        Byte years = null;
        do {
            if (years != null)
                System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (Year): ");
            years = scanner.nextByte();
        } while (!(years > 0 && years <= 30));
        var numberOfPayments = years * MONTHS_IN_YEAR;

        var special_value = Math.pow(1 + monthlyInterestRate, numberOfPayments);
        var mortgage = principal * ((monthlyInterestRate * special_value) / (special_value - 1));
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
