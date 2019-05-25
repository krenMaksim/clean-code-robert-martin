package com.kren.clean.code.book.listing10_5.e2e;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

class PrintPrimesE2eUtil {
    private PrintPrimesE2eUtil() {
        throw new AssertionError();
    }

    public static String getActualOutPut() {
        File actualOutPut = new File("src/test/resources/actual-output.txt");
        return readToString(actualOutPut);
    }

    private static String readToString(File file) {
        try {
            return Files.asCharSource(file, Charsets.UTF_8)
                        .read();
        } catch (IOException e) {
            throw new RuntimeException("can't read file: " + file.getAbsolutePath());
        }
    }
}
