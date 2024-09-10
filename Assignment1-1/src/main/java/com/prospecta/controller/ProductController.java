package com.prospecta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.Entity.NewProduct;
import com.prospecta.Entity.Product;
import com.prospecta.Service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	public ProductService service;

	// task 1 
	@GetMapping("Products/category")
	public ResponseEntity<Product> getProductsCategory(){
		return new ResponseEntity<>(service.getProductCategory(), HttpStatus.OK);
	}
	
	// task 2 
	@PostMapping("Products/add")
    public ResponseEntity<String> addProduct(@RequestBody NewProduct newProduct) {
        ResponseEntity<String> response = service.addNewProduct(newProduct);
        return ResponseEntity.ok(response.getBody());
    }
	
//	
	

}