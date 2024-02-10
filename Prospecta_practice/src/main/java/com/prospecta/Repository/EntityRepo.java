package com.prospecta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.Entity.EntityClass;


public interface EntityRepo extends JpaRepository<EntityClass, String> {

}
