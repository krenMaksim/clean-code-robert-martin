package com.kren.clean.code.book.listing10_5;

class PrimeTable {
    private final int[] primes;
    private final int columnsNumber;
    private final int rowsNumber;
    private final int primesAmount;

    public PrimeTable(int[] primes, int columnsNumber, int rowsNumber) {
        this.primes = primes;
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        primesAmount = primes.length - 1;
    }

    public void printTable() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= primesAmount) {
            printPageHeader(pageNumber);
            printPageBody(pageOffset);
            printPageFooter();
            pageNumber++;
            pageOffset = pageOffset + rowsNumber * columnsNumber;
        }
    }

    private void printPageBody(int pageOffset) {
        for (int rowOffset = pageOffset; rowOffset < pageOffset + rowsNumber; rowOffset++) {
            printRow(rowOffset);
            printBlankLine();
        }
    }

    private void printRow(int rowOffset) {
        for (int column = 0; column < columnsNumber; column++) {
            int primeIndex = rowOffset + column * rowsNumber;
            if (primeIndex <= primesAmount) {
                System.out.format("%10d", primes[primeIndex]);
            }
        }
    }

    private void printPageHeader(int pageNumber) {
        System.out.println("The First " + primesAmount + " Prime Numbers --- Page " + pageNumber);
        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println("");
    }

    private static void printPageFooter() {
        System.out.println("\f");
    }
}
