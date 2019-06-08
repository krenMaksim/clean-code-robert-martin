package com.kren.clean.code.book.listing10_5;

public class PrintPrimes {
    private static final int PRIMES_NUMBER = 1000;
    private static final int COLUMNS_PER_PAGE = 4;
    private static final int ROWS_PER_PAGE = 50;

    public static void main(String[] args) {
        int primes[] = PrimeGenerator.generate(PRIMES_NUMBER);
        TabularReport report = new TabularReport(COLUMNS_PER_PAGE, ROWS_PER_PAGE);
        report.showReport(primes);
    }
}
