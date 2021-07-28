package com.victor.java.backend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.java.backend.dto.UserDTO;

@RestController // permite a criação de métodos que serão chamados via Web utilizando o protocolo HTTP.
public class UserController {
	
	@GetMapping("/msg") // faz com que o metodo a seguir seja executado no mapeamento /msg
	public String getMessage() {
		return "Rest Testado";
	}
	
	public static List<UserDTO> users = new ArrayList<UserDTO>();
	
	@PostConstruct // indica que o metodo a seguir vai ser exeutado assim que o container for iniciado
	public void initializesList() { // Inicializa a lista de users ja com alguns usuarios
		UserDTO userDTO = new UserDTO();
	    userDTO.setName("Eduardo");
	    userDTO.setCpf("123");
	    userDTO.setEndereco("Rua a");
	    userDTO.setEmail("eduardo@email.com");
	    userDTO.setPhone("1234-3454");
	    userDTO.setRegistrationDate(new Date());
	    
	    UserDTO userDTO2 = new UserDTO();
	    userDTO2.setName("Luiz");
	    userDTO2.setCpf("456");
	    userDTO2.setEndereco("Rua b");
	    userDTO2.setEmail("luiz@email.com");
	    userDTO2.setPhone("1234-3454");
	    userDTO2.setRegistrationDate(new Date());
	    
	    UserDTO userDTO3 = new UserDTO();
	    userDTO3.setName("Bruna");
	    userDTO3.setCpf("678");
	    userDTO3.setEndereco("Rua c");
	    userDTO3.setEmail("bruna@email.com");
	    userDTO3.setPhone("1234-3454");
	    userDTO3.setRegistrationDate(new Date());
	    
	    users.add(userDTO);
	    users.add(userDTO2);
	    users.add(userDTO3);
	}
	
	@GetMapping("/users") // faz com que o metodo a seguir seja executado no mapeamento /users
	public List<UserDTO> getUsers() { 
		return users;
	}
}
