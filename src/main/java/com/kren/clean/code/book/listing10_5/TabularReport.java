package com.kren.clean.code.book.listing10_5;

class TabularReport {
    private final int columnsPerPage;
    private final int rowsPerPage;
    private int[] data;
    private int numberAmount;

    public TabularReport(int columnsPerPage, int rowsPerPage) {
        this.columnsPerPage = columnsPerPage;
        this.rowsPerPage = rowsPerPage;
    }

    private TabularReport(TabularReport report, int[] data) {
        columnsPerPage = report.columnsPerPage;
        rowsPerPage = report.rowsPerPage;
        this.data = data;
        numberAmount = data.length - 1;
    }

    public void showReport(int[] data) {
        new TabularReport(this, data).showReport();
    }

    private void showReport() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberAmount) {
            printPageHeader(pageNumber);
            printPageBody(pageOffset);
            printPageFooter();
            pageNumber++;
            pageOffset = pageOffset + rowsPerPage * columnsPerPage;
        }
    }

    private void printPageHeader(int pageNumber) {
        System.out.println("The First " + numberAmount + " Prime Numbers --- Page " + pageNumber);
        printBlankLine();
    }

    private void printPageBody(int pageOffset) {
        for (int rowOffset = pageOffset; rowOffset < pageOffset + rowsPerPage; rowOffset++) {
            printRow(rowOffset);
            printBlankLine();
        }
    }

    private void printRow(int rowOffset) {
        for (int column = 0; column < columnsPerPage; column++) {
            int numberIndex = rowOffset + column * rowsPerPage;
            if (numberIndex <= numberAmount) {
                System.out.format("%10d", data[numberIndex]);
            }
        }
    }

    private static void printPageFooter() {
        System.out.println("\f");
    }

    private static void printBlankLine() {
        System.out.println("");
    }
}
