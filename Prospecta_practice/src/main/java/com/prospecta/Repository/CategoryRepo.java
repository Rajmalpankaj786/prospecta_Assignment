package com.prospecta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prospecta.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
