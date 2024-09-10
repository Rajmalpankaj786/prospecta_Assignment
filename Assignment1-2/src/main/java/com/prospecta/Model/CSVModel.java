package com.prospecta.Model;

public class CSVModel {
    private String[][] sheet;  // 2D array to store the CSV data

    // Constructor: Initializes the sheet (CSV data)
    public CSVModel(String[][] sheet) {
        this.sheet = sheet;
    }

    // Process all cells to evaluate formulas
    public void processSheet() {
        for (int row = 0; row < sheet.length; row++) {
            for (int col = 0; col < sheet[row].length; col++) {
                sheet[row][col] = evaluateCell(row, col);
            }
        }
    }

    // This method evaluates each cell (value or formula)
    private String evaluateCell(int row, int col) {
        String cell = sheet[row][col].trim();

        if (cell.startsWith("=")) {
            return evaluateFormula(cell.substring(1));  // Process formulas
        }
        return cell;  // Return the value if it's not a formula
    }

    // Evaluate simple formulas (like "A1 + B1")
    private String evaluateFormula(String formula) {
        return formula.replace("A1", "5").replace("B2", "8");  // Dummy evaluation for beginners
    }

    // Get the processed sheet
    public String[][] getProcessedSheet() {
        return sheet;
    }
}

