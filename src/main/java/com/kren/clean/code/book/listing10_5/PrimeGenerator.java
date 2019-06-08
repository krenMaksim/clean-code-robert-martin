package com.kren.clean.code.book.listing10_5;

class PrimeGenerator {
    private static final int[] NO_DATA = new int[0];

    public static int[] generate(int primesNumber) {
        if (primesNumber < 1) {
            return NO_DATA;
        }
        return new PrimeGenerator(primesNumber).generate();
    }

    private static final int FIRST_PRIME_NUMBER = 2;
    private static final int ORD_MAX = 30;

    private final int primes[];
    private final int mult[] = new int[ORD_MAX + 1];
    private int primeTempValue = 1;
    private int ord = 2;
    private int square = 9;

    private PrimeGenerator(int primesNumber) {
        primes = new int[primesNumber + 1];
        primes[1] = FIRST_PRIME_NUMBER;
    }

    private int[] generate() {
        for (int i = 2; i < primes.length; i++) {
            primes[i] = findNextPrime();
        }
        return primes;
    }

    private int findNextPrime() {
        while (true) {
            primeTempValue = primeTempValue + 2;
            if (primeTempValue == square) {
                ord++;
                square = primes[ord] * primes[ord];
                mult[ord - 1] = primeTempValue;
            }
            boolean jPrime = true;
            for (int i = 2; i < ord; i++) {
                mult[i] = getMult(mult[i], primes[i]);
                if (mult[i] == primeTempValue) {
                    jPrime = false;
                }
            }

            if (jPrime) {
                break;
            }
        }
        return primeTempValue;
    }

    private int getMult(int currentMult, int prime) {
        while (currentMult < primeTempValue) {
            currentMult = currentMult + 2 * prime;
        }
        return currentMult;
    }
}
