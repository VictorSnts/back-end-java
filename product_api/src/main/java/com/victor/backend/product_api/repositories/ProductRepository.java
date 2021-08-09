package com.victor.backend.product_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victor.backend.product_api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	// COM ERRO
//	@Query(value = "select p from products.product as p join products.category as c on p.category_id = c.id where c.id = :categoryId")
//	public List<Product> getProductByCategory(@Param("categoryId") Integer categoryId);

	public Product findByProductIdentifier(String productIdentifier);
}