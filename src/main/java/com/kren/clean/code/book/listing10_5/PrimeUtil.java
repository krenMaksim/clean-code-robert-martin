package com.kren.clean.code.book.listing10_5;

class PrimeUtil {
    private static final int ORDMAX = 30;

    private PrimeUtil() {
        throw new AssertionError();
    }

    public static int[] findPrimes(int primesAmount) {
        int primes[] = new int[primesAmount + 1];
        primes[1] = 2;


        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N;
        int MULT[] = new int[ORDMAX + 1];



        while (K < primesAmount) {
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

        return primes;
    }
}
