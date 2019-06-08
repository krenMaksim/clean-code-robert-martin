package com.kren.clean.code.book.listing10_5;

class PrimeCalculator {
    public static int[] findPrimes(int primesAmount) {
        checkPrimesAmount(primesAmount);
        return new PrimeCalculator(primesAmount).findPrimes();
    }

    private static void checkPrimesAmount(int primesAmount) {
        if (primesAmount < 1) {
            throw new IllegalArgumentException("primesAmount must be >=1");
        }
    }

    private static final int FIRST_PRIME_NUMBER = 2;
    private static final int ORDMAX = 30;

    private final int primes[];
    private final int mult[] = new int[ORDMAX + 1];
    private int primeTempValue = 1;
    private int ord = 2;
    private int square = 9;

    private PrimeCalculator(int primesAmount) {
        primes = new int[primesAmount + 1];
        primes[1] = FIRST_PRIME_NUMBER;
    }

    private int[] findPrimes() {
        for (int i = 2; i < primes.length; i++) {
            primes[i] = calculatePrime();
        }
        return primes;
    }

    private int calculatePrime() {
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
