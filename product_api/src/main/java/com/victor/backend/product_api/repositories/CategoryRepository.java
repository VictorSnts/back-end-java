package com.victor.backend.product_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.backend.product_api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
