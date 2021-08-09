package com.victor.backend.product_api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victor.backend.product_api.dto.ProductDTO;
import com.victor.backend.product_api.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products/")
	public List<ProductDTO> getProducts() {
		List<ProductDTO> products = productService.getAll();
		return products;
	}

	// COM ERRO
//	@GetMapping("/products/category/{categoryId}")
//	public List<ProductDTO> getProductByCategoryId(@PathVariable Integer categoryId){
//		List<ProductDTO> products = productService.getProductByCategoryId();
//		return products;
//	}	

	@GetMapping("/product/{id}")
	public ProductDTO findByProductIdentifier(@PathVariable String id) {
		return productService.findByProductIdentifier(id);
	}

	@PostMapping("/product")
	public ProductDTO newProduct(@Valid @RequestBody ProductDTO product) {
		return productService.save(product);
	}

	@DeleteMapping("/product/{id}")
	public ProductDTO removeProduct(@PathVariable Integer id) {
		return productService.delete(id);
	}

}
