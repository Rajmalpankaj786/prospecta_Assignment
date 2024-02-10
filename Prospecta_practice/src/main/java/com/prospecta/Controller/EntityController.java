package com.prospecta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.Entity.EntityClass;
import com.prospecta.Service.EntityService;



@RestController
@RequestMapping(value = "/entites")
public class EntityController {

	@Autowired
	private EntityService entityService;
	
	@PostMapping
	public ResponseEntity<EntityClass> postEntity(@RequestBody EntityClass entity){
		return new ResponseEntity<EntityClass>(entityService.postEntity(entity),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EntityClass>> viewAllEntity(){
		return new ResponseEntity<List<EntityClass>>(entityService.viewAllEntity(),HttpStatus.OK);
	}
	
	
}
