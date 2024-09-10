# prospecta_Assignment
## Assignment 1. <br>
This project is a Spring Boot REST API implementation using the Fake Store API. It contains two tasks:

Task 1: Retrieve product details based on the category passed as an input parameter. <br>
Task 2: Add a new product entry using a POST request.<br>
Task 3: What are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

API Endpoints <br>
Task 1: List Products by Category <br>
Endpoint: /products/category/jewelery <br>
Method: GET <br>
Description: Fetch a list of products based on the category passed as an input parameter.<br>
Example Request:<br>
GET http://localhost:8080/products/category/jewelery<br>
<br>
Task 2: Add a New Product<br>
Endpoint: /api/v1/products/add<br>
Method: POST<br>
Description: Add a new product to the Fake Store API.<br>
Example Request:<br>
POST http://localhost:8080/products/add <br>
<br> 
Task 3: adding new data in the database is not permanent, it's a temporary base so this is the challenge.<br>

<br>
## Assignment 2: <br>
CSV Formula Evaluator<br>
Problem Description<br>
This program processes a CSV file where some cells contain values, and others contain Excel-like formulas. The program reads the CSV, evaluates any formulas, and outputs a new CSV file with the calculated results.<br>

Example Input <br>
	A	B	C <br>
1	5	3	=5+A1 <br>
2	7	8	=A2+B2 <br>
3	9	=4+5	=C2+B3 <br>
Expected Output <br>
After evaluation, the program should replace formulas with calculated values and produce a CSV like:<br>
	A	B	C <br>
1	5	3	10 <br>
2	7	8	15 <br>
3	9	9	24 <br>

que 1: How will you tackle the challenge above?<br>
Ans: Step :<br>
1. Read the CSV File: Use a library like OpenCSV or manually parse it.<br>
2. Identify Formulas: Detect if a cell contains a formula.<br>
3. Evaluate Formulas: Recursively resolve formulas and replace them with calculated values.<br>

que 2: What type of errors you would you check for?<br>
Ans: Handle Errors: Handle undefined cells, invalid formulas, and circular references.<br>
