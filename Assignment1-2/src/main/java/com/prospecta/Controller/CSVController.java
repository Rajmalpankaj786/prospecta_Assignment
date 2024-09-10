package com.prospecta.Controller;

import java.io.IOException;

import com.prospecta.Model.CSVModel;
import com.prospecta.Service.CSVView;

public class CSVController {

    private CSVModel model;  // Model (logic/data)
    private CSVView view;    // View (input/output)

    // Constructor to connect model and view
    public CSVController(CSVModel model, CSVView view) {
        this.model = model;
        this.view = view;
    }

    // This method controls the whole process
    public void processSheet(String inputFile, String outputFile) throws IOException {
        String[][] data = view.readCSV(inputFile);  // Step 1: Read CSV

        model = new CSVModel(data);  // Initialize the model with the input data
        model.processSheet();          // Step 2: Process the data (evaluate formulas)

        view.writeCSV(outputFile, model.getProcessedSheet());  // Step 3: Write output to CSV
    }
}

