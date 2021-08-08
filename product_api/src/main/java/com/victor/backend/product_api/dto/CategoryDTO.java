package com.victor.backend.product_api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.victor.backend.product_api.model.Category;

public class CategoryDTO {

	@NotNull
	private Integer id;
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// IMPLEMENTAR CONVERSAO
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

}
