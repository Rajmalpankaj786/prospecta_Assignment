package com.prospecta.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.Entity.Category;
import com.prospecta.Service.CategotyService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategotyService categotyService;
	
	@PostMapping
	public ResponseEntity<Category> postEntity(@RequestBody Category Category){
		return new ResponseEntity<Category>(categotyService.postCategory(Category) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> viewAllCategory(){
		return new ResponseEntity<List<Category>>(categotyService.viewAllCategory(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable Integer id){
		return new ResponseEntity<Optional<Category>>(categotyService.findById(id) ,HttpStatus.OK);
	}
	
	
	
	
}
