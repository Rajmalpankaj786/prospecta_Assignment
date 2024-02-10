package com.prospecta.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.Entity.Category;
import com.prospecta.Entity.EntityClass;
import com.prospecta.Exception.NotFoundException;
import com.prospecta.Repository.CategoryRepo;
import com.prospecta.Repository.EntityRepo;


@Service
public class EntityService {
    
	
	@Autowired
	private EntityRepo entityRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public EntityClass postEntity(EntityClass entity) {
		Integer categoryId = entity.getCategoryId();
		Optional<Category> cat = categoryRepo.findById(categoryId);
		if (cat.get() == null) {
			throw new NotFoundException("given id does't exists : " + categoryId);
		}else {
			return entityRepo.save(entity);
		}
		
	}
	
	public List<EntityClass> viewAllEntity(){
		return entityRepo.findAll();
		}
}
