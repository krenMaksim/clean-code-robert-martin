package com.kren.clean.code.book.listing10_5;

public class PrintPrimes {
    private static final int PRIMES_AMOUNT = 1000;
    private static final int ROWS_MAX_NUMBER = 50;
    private static final int COLUMNS_MAX_NUMBER = 4;

    public static void main(String[] args) {
        int primes[] = PrimeCalculator.findPrimes(PRIMES_AMOUNT);
        NumbersTable.printTable(primes, COLUMNS_MAX_NUMBER, ROWS_MAX_NUMBER);
    }
}
