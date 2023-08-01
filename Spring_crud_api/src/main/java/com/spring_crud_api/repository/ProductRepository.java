package com.spring_crud_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_crud_api.model.Products;

public interface ProductRepository extends JpaRepository<Products,Integer> {

	Products getByName(String name);

	

   

	



}
  