package com.prospecta;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prospecta.Controller.CSVController;
import com.prospecta.Service.CSVView;

@SpringBootApplication
public class Assignment12Application {

	public static void main(String[] args) throws IOException {
		
		 CSVView view = new CSVView();  // Create view

	        // Initialize the controller with empty model and view
	        CSVController controller = new CSVController(null, view);

	        // Process the input and output files
	        controller.processSheet("input.csv", "output.csv");
	        
	        
	}

}
