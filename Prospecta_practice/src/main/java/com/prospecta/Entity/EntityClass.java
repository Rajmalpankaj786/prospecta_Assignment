package com.prospecta.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EntityClass {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	/* like a String primary key*/
	private String auth;
	/* Mathematics subject */
	private String title;
	/* using a logical operations*/
	private String description;
	/* true and false*/
	private boolean https;
	/* yes , no and unknown*/
	private String cors;
	/* example : Science & Math*/
	private Integer categoryId;
	
}
