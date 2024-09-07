package com.prospecta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RestController
public class RestClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/products/category/jewelery")
    public ResponseEntity<String> getExample() {
        String url = "https://fakestoreapi.com/products/category/jewelery";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
    
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
    	  String url = "https://fakestoreapi.com/products";
    	  
        HttpEntity<Product> request = new HttpEntity<>(product);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
