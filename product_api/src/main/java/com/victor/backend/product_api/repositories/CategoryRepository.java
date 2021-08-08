package com.victor.backend.product_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.backend.product_api.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}