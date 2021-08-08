package com.victor.backend.product_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.victor.backend.product_api.dto.CategoryDTO;

@Entity
@Table(name = "category", schema = "products")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Category convert(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		return category;
	}

}
