package com.prospecta.Service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.prospecta.Entity.NewProduct;
import com.prospecta.Entity.Product;
import com.prospecta.Exception.ProductException;

@Service
public class ProductService {
	
	private final RestTemplate restTemplate = new RestTemplate();
    
    public Product getProductCategory() {
    	Product response= restTemplate.getForObject("https://fakestoreapi.com/products/category/jewelery", Product.class);
    	if (response != null) {
            return response;
        } else {
            throw new ProductException("Products not found in category");
        }
    }
    
    public ResponseEntity<String> addNewProduct(NewProduct newProduct) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<NewProduct> entity = new HttpEntity<>(newProduct, headers);
        
        if (entity == null) {
        	throw new ProductException("Failed to add new product.");
        }
        else {
        return restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.POST, entity, String.class);
        }
    }
}
