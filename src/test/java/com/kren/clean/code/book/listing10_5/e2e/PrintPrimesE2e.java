package com.kren.clean.code.book.listing10_5.e2e;

import static com.kren.clean.code.book.listing10_5.e2e.PrintPrimesE2eUtil.getActualOutPut;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kren.clean.code.book.listing10_5.PrintPrimes;

public class PrintPrimesE2e {
    private final ByteArrayOutputStream printPrimesOutput = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String[] NO_ARGS = new String[0];

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(printPrimesOutput));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void compareAppOutputWithActual() {
        String actualOutPut = getActualOutPut();
        PrintPrimes.main(NO_ARGS);
        assertEquals(actualOutPut, printPrimesOutput.toString());
    }
}
