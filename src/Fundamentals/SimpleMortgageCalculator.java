package Fundamentals;

import java.text.NumberFormat;
import java.util.Scanner;

public class SimpleMortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        var scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        var principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        var annualInterestRate = scanner.nextFloat();
        var monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Year): ");
        var years = scanner.nextByte();
        var numberOfPayments = years * MONTHS_IN_YEAR;

        var special_value = Math.pow(1 + monthlyInterestRate, numberOfPayments);
        var mortgage = principal * ((monthlyInterestRate * special_value) / (special_value - 1));

        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
