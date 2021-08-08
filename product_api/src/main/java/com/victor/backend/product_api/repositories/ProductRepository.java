package com.victor.backend.product_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victor.backend.product_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query(value = "select p " + 
//				   "from product p " + 
//			       "join category c on p.category.id = c.id "
//			+ "where c.id = :categoryId ")
//	public List<Product> getProductByCategory(@Param("categoryId") Integer categoryId);
//
	public Product findByProductIdentifier(String productIdentifier);
}
