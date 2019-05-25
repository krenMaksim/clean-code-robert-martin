package com.kren.clean.code.book.listing10_5;

public class PrintPrimes {
    private static final int PRIMES_AMOUNT = 1000;
    private static final int ROWS_MAX_NUMBER = 50;
    private static final int COLUMNS_MAX_NUMBER = 4;
    private static final int ORDMAX = 30;
    private static final int PRIMES[] = new int[PRIMES_AMOUNT + 1];

    public static void main(String[] args) {

        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N;
        int MULT[] = new int[ORDMAX + 1];

        PRIMES[1] = 2;

        while (K < PRIMES_AMOUNT) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = PRIMES[ORD] * PRIMES[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) {
                        MULT[N] = MULT[N] + PRIMES[N] + PRIMES[N];
                    }
                    if (MULT[N] == J) {
                        JPRIME = false;
                    }
                    N = N + 1;
                }
            } while (!JPRIME);

            K = K + 1;
            PRIMES[K] = J;
        }
        printTableOfPrimes();
    }

    private static void printTableOfPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= PRIMES_AMOUNT) {
            printPageHeader(pageNumber);
            for (int rowOffset = pageOffset; rowOffset < pageOffset + ROWS_MAX_NUMBER; rowOffset++) {
                for (int column = 0; column < COLUMNS_MAX_NUMBER; column++)
                    if (rowOffset + column * ROWS_MAX_NUMBER <= PRIMES_AMOUNT) {
                        int primeIndex = rowOffset + column * ROWS_MAX_NUMBER;
                        printPrime(primeIndex);
                    }
                printBlankLine();
            }
            printPageFooter();
            pageNumber++;
            pageOffset = pageOffset + ROWS_MAX_NUMBER * COLUMNS_MAX_NUMBER;
        }
    }

    private static void printPrime(int primeIndex) {
        System.out.format("%10d", PRIMES[primeIndex]);
    }

    private static void printPageHeader(int pageNumber) {
        System.out.println("The First " + PRIMES_AMOUNT + " Prime Numbers --- Page " + pageNumber);
        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println("");
    }

    private static void printPageFooter() {
        System.out.println("\f");
    }
}
