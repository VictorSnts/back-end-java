package com.victor.backend.user_api.dto;

import java.util.Date;

import com.victor.backend.user_api.model.User;

public class UserDTO {

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

	
	// Metodo para conversao de objetos do tipo UserModel para tipo UserDTO
	public static UserDTO convert(User userModel) {
		UserDTO user = new UserDTO();
        user.setName(userModel.getName());
        user.setAddress(userModel.getAddress());
        user.setCpf(userModel.getCpf());
        user.setEmail(userModel.getEmail());
        user.setPhone(userModel.getPhone());
        user.setRegistrationDate(userModel.getRegistrationDate());
        return user;
	}
}
