package com.prospecta.Service;

import java.io.*;
import java.util.*;

public class CSVView {

    // Reads the input CSV and converts it to a 2D array
    public String[][] readCSV(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String[]> data = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");  // Split rows by commas
            data.add(row);
        }
        br.close();
        return data.toArray(new String[0][0]);
    }

    // Writes the processed data back to a new CSV file
    public void writeCSV(String fileName, String[][] sheet) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String[] row : sheet) {
            writer.write(String.join(",", row));  // Join cells with commas
            writer.newLine();
        }
        writer.close();
    }
}
