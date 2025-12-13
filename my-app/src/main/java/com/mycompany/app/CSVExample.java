
package com.mycompany.app;

import org.esa.snap.core.util.io.CsvReader;

import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class CSVExample {
    public static void main(String[] args) {
        String filePath = "data.csv";
        // Use comma as the separator
        char[] separators = { ',' };
        try (
            Reader fileReader = new FileReader(filePath);
            CsvReader csv = new CsvReader(fileReader, separators)
        ) {
            // Read and print records until EOF
            String[] record;
            boolean firstLine = true;

            while ((record = csv.readRecord()) != null) {
                if (firstLine) {
                    // Print header line if desired
                    System.out.println("Header: " + Arrays.toString(record));
                    firstLine = false;
                } else {
                    // Process a normal data row
                    String name = record[0];
                    String age = record[1];
                    String city = record[2];
                    System.out.println(name + " (" + age + ") - " + city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
