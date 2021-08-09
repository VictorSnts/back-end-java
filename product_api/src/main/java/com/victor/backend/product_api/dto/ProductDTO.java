package com.victor.backend.product_api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.victor.backend.product_api.model.Product;

public class ProductDTO {
	
	@NotBlank
	private String productIdentifier;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotNull
	private Float price;
	@NotNull
	private CategoryDTO category;

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	// IMPLEMENTAR CONVERSAO
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO =  new ProductDTO();
		productDTO.setProductIdentifier(product.getProductIdentifier());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		if (product.getCategory() != null) {
			productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
		}
		return productDTO;
	}

}
