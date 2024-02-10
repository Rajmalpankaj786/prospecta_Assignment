package com.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CsvClass {

	    private static final String CSV_INPUT_FILE_PATH = "input.csv";
	    private static final String CSV_OUTPUT_FILE_PATH = "output.csv";
	    private HashMap<String, String> cellMap = new HashMap<>();
	    
	    /* Method to read CSV file and populate HashMap */
	    private void readCSV() {
	        try (BufferedReader br = new BufferedReader(new FileReader(CSV_INPUT_FILE_PATH))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(": ");
	                String cell = parts[0].trim();
	                String value = parts[1].trim();
	                cellMap.put(cell, value);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /*  Method to evaluate formulas recursively */
	    private int evaluateFormula(String formula) {
	        if (formula.startsWith("=")) {
	            String[] tokens = formula.substring(1).split("\\+"); 
	            int sum = 0;
	            for (String token : tokens) {
	                if (token.matches("[A-Z]\\d")) { 
	                    String cell = token;
	                    String cellValue = cellMap.get(cell);
	                    if (cellValue != null) {
	                        int value = evaluateFormula(cellValue);
	                        sum += value;
	                    }
	                } else if (token.matches("\\d+")) {
	                    sum += Integer.parseInt(token);
	                }
	            }
	            return sum;
	        } else { // If formula is a single value
	            return Integer.parseInt(formula);
	        }
	    }
	    
	    /*Method to write CSV output with results */
	    
	    private void writeCSV() {
	        try (FileWriter writer = new FileWriter(CSV_OUTPUT_FILE_PATH)) {
	            for (String cell : cellMap.keySet()) {
	                int value = evaluateFormula(cellMap.get(cell));
	                writer.append(cell).append(": ").append(String.valueOf(value)).append("\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void main(String[] args) {
	    	CsvClass evaluator = new CsvClass();
	        evaluator.readCSV();
	        evaluator.writeCSV();
	        System.out.println("Output CSV file generated successfully.");
	    }
}
