package com.prospecta_csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvFormulaEvaluator {

    // To hold cell references (like A1, B2) and their corresponding values
    private static final Map<String, Double> cellValues = new HashMap<>();

    public static void main(String[] args) {
        String inputFilePath = "input.csv";
        String outputFilePath = "output.csv";

        processCsv(inputFilePath, outputFilePath);
    }

    // Function to process the CSV file and evaluate all formulas
    public static void processCsv(String inputFile, String outputFile) {
        try (
            Reader reader = new FileReader(inputFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)
        ) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            int rowNum = 1;
            for (CSVRecord record : records) {
                String[] rowOutput = new String[record.size()];

                for (int colNum = 0; colNum < record.size(); colNum++) {
                    String cellValue = record.get(colNum).trim();
                    String cellReference = getCellReference(colNum, rowNum);
                    rowOutput[colNum] = evaluateCell(cellValue, cellReference);
                }
                csvPrinter.printRecord((Object[]) rowOutput);
                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper function to convert column/row indices into cell references like A1, B2
    public static String getCellReference(int col, int row) {
        return "" + (char) ('A' + col) + row;
    }

    // Function to evaluate a cell value or formula
    public static String evaluateCell(String cell, String cellReference) {
        if (cell.startsWith("=")) {
            // It's a formula, so evaluate it
            String formula = cell.substring(1);  // Remove '='
            return String.valueOf(evaluateFormula(formula, cellReference));
        } else {
            // It's a value, store it as a number
            try {
                double value = Double.parseDouble(cell);
                cellValues.put(cellReference, value);
                return cell;
            } catch (NumberFormatException e) {
                return "0";  // Default to 0 if the value isn't a number
            }
        }
    }

    // Evaluates the formula using basic arithmetic operations
    public static double evaluateFormula(String formula, String currentCell) {
        // Replace cell references (like A1, B2) with actual values
        Pattern pattern = Pattern.compile("([A-Z]+\\d+)");
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            String cellRef = matcher.group(1);
            if (cellValues.containsKey(cellRef)) {
                formula = formula.replace(cellRef, String.valueOf(cellValues.get(cellRef)));
            } else {
                System.out.println("Error: Cell reference " + cellRef + " not found");
                return 0;
            }
        }

        // Evaluate the final formula using Java's ScriptEngine
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            return (double) engine.eval(formula);
        } catch (ScriptException e) {
            System.out.println("Error evaluating formula: " + formula);
            return 0;
        }
    }
}

