package com.victor.backend.user_api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.backend.user_api.dto.UserDTO;
import com.victor.backend.user_api.services.UserService;

@RestController // permite a criação de métodos que serão chamados via Web utilizando o
				// protocolo HTTP.
public class UserController {


	@Autowired
	private UserService userService;

	@GetMapping("/user/") // faz com que o metodo a seguir seja executado no mapeamento /user
	public List<UserDTO> getUsers() {
		List<UserDTO> users = userService.getAll();
		return users;
	}

	@GetMapping("/user/{id}") 
	public UserDTO findById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@GetMapping("/user/cpf/{cpf}") 
	public UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}

	@GetMapping("/user/search") 
	public List<UserDTO> queryByName(@RequestParam(name = "name", required = true) String name) { // @RequestParam pega o parametro passado via URL
		return userService.qweryByName(name + "%");
	}

	@PostMapping("/user") 
	public UserDTO newUser(@RequestBody UserDTO user) { // @RequestBody pega o corpo da requisicao
		user.setRegistrationDate(new Date());
		return userService.save(user);
	}

	@DeleteMapping("/user/{id}")
	public UserDTO removeUser(@PathVariable Integer id) {
		return userService.delete(id);
	}

}
