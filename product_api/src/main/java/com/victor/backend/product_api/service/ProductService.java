package com.victor.backend.product_api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.backend.product_api.dto.ProductDTO;
import com.victor.backend.product_api.model.Product;
import com.victor.backend.product_api.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();

		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
	}
	
	// COM ERRO
//	public List<ProductDTO> getProductByCategoryId(Integer categoryId) {
//		List<Product> products =productRepository.getProductByCategory(categoryId);
//		return products.stream().map(ProductDTO::convert).collect(Collectors.toList());
//	}
	
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if(product != null) {
			return ProductDTO.convert(product);
		}
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) { 
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}
	
	public ProductDTO delete(Integer productID) {
		Optional<Product> product = productRepository.findById(productID);
		if (product.isPresent()) {
			productRepository.delete(product.get());
		}
		return null;
	}
	
}
