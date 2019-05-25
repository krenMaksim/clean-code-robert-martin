package com.kren.clean.code.book.listing10_5;

public class PrintPrimes {
    private static final int PAGE_SIZE = 1000;
    private static final int RR = 50;
    private static final int CC = 4;
    private static final int ORDMAX = 30;
    private static final int P[] = new int[PAGE_SIZE + 1];

    public static void main(String[] args) {

        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N;
        int MULT[] = new int[ORDMAX + 1];

        P[1] = 2;

        while (K < PAGE_SIZE) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) {
                        MULT[N] = MULT[N] + P[N] + P[N];
                    }
                    if (MULT[N] == J) {
                        JPRIME = false;
                    }
                    N = N + 1;
                }
            } while (!JPRIME);

            K = K + 1;
            P[K] = J;
        }
        printResultTable();
    }

    private static void printResultTable() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= PAGE_SIZE) {
            System.out.println("The First " + PAGE_SIZE + " Prime Numbers --- Page " + pageNumber);
            System.out.println("");
            for (int rowOffset = pageOffset; rowOffset < pageOffset + RR; rowOffset++) {
                for (int C = 0; C < CC; C++)
                    if (rowOffset + C * RR <= PAGE_SIZE) {
                        System.out.format("%10d", P[rowOffset + C * RR]);
                    }
                System.out.println("");
            }
            System.out.println("\f");
            pageNumber = pageNumber + 1;
            pageOffset = pageOffset + RR * CC;
        }
    }
}
