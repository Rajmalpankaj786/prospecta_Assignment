package com.prospecta.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.Entity.Category;
import com.prospecta.Repository.CategoryRepo;

@Service
public class CategotyService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category postCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> viewAllCategory(){
		return categoryRepo.findAll();
	}
	
	 public Optional<Category> findById(Integer category) {
		return categoryRepo.findById(category);
	}
	
	
}
