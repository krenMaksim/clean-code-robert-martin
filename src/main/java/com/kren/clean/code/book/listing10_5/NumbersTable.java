package com.kren.clean.code.book.listing10_5;

class NumbersTable {
    public static void printTable(int[] numbers, int columnsNumber, int rowsNumber) {
        new NumbersTable(numbers, columnsNumber, rowsNumber).printTable();
    }

    private final int[] numbers;
    private final int columnsNumber;
    private final int rowsNumber;
    private final int numberAmount;

    private NumbersTable(int[] numbers, int columnsNumber, int rowsNumber) {
        this.numbers = numbers;
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        numberAmount = numbers.length - 1;
    }

    private void printTable() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberAmount) {
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
            int numberIndex = rowOffset + column * rowsNumber;
            if (numberIndex <= numberAmount) {
                System.out.format("%10d", numbers[numberIndex]);
            }
        }
    }

    private void printPageHeader(int pageNumber) {
        System.out.println("The First " + numberAmount + " Prime Numbers --- Page " + pageNumber);
        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println("");
    }

    private static void printPageFooter() {
        System.out.println("\f");
    }
}
