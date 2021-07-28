package com.victor.java.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // permite a criação de métodos que serão chamados via Web utilizando o protocolo HTTP.
public class UserController {
	
	@GetMapping("/msg")
	public String getMessage() {
		return "Rest Testado";
	}
}
