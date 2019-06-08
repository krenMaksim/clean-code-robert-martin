package com.kren.clean.code.book.listing10_5;

public class PrintPrimes {
    private static final int PRIMES_AMOUNT = 1000;
    private static final int ROWS_MAX_NUMBER = 50;
    private static final int COLUMNS_MAX_NUMBER = 4;
    private static final int ORDMAX = 30;
    private static final int primes[] = new int[PRIMES_AMOUNT + 1];

    public static void main(String[] args) {

        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N;
        int MULT[] = new int[ORDMAX + 1];

        primes[1] = 2;

        while (K < PRIMES_AMOUNT) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = primes[ORD] * primes[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) {
                        MULT[N] = MULT[N] + primes[N] + primes[N];
                    }
                    if (MULT[N] == J) {
                        JPRIME = false;
                    }
                    N = N + 1;
                }
            } while (!JPRIME);

            K = K + 1;
            primes[K] = J;
        }
        PrimeTable primeTable = new PrimeTable(primes, COLUMNS_MAX_NUMBER, ROWS_MAX_NUMBER);
        primeTable.printTableOfPrimes();
    }
}
