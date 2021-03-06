package com.victor.backend.user_api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.victor.backend.user_api.dto.UserDTO;

@Entity // Indica que essa classe é uma entidade do banco de dados
@Table(name="user", schema = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica a forma em que o ID é gerado
	private Integer id;
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String phone;
	private Date registrationDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	// Metodo para conversao de objetos do tipo UserDTO para tipo userModel
	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setAddress(userDTO.getAddress());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setRegistrationDate(userDTO.getRegistrationDate());
		return user;
	}

}
