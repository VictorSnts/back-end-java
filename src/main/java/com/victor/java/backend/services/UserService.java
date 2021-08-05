package com.victor.java.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.java.backend.dto.UserDTO;
import com.victor.java.backend.model.UserModel;
import com.victor.java.backend.repositories.UserRepository;

@Service // indica que esta é uma classe de servico
public class UserService {

	@Autowired // anotacao usada para realizar injeção de dependência
	private UserRepository userRepository;

	public List<UserDTO> getAll() {
		List<UserModel> users = userRepository.findAll();

		// retorna uma lista que foi Transformada em um stream e foi chamado metodo map
		// para transformar a lista de entidades em uma lista de DTOs
		return users.stream().map(UserDTO::convert).collect(Collectors.toList());
		
		// mais sobre stream https://www.oracle.com/br/technical-resources/articles/java/processing-streams-java-se-8.html 
	}

	public UserDTO findById(Integer userID) { // Busca o usuario por um id especifico
		Optional<UserModel> userModel = userRepository.findById(userID);
		if (userModel.isPresent()) {
			return UserDTO.convert(userModel.get());
		}
		return null;
	}

	public UserDTO save(UserDTO userDTO) { // Salva um usuario no banco de dados
		UserModel userModel = userRepository.save(UserModel.convert(userDTO));
		return UserDTO.convert(userModel);
	}
	
	public UserDTO delete(Integer userID) { // remove o usuario por um id especifico
		Optional<UserModel> userModel = userRepository.findById(userID);
		if (userModel.isPresent()) {
			userRepository.delete(userModel.get());
		}
		return null;
	}
	
	public UserDTO findByCpf(String userCpf) { // busca o usuario por um cpf especifico
		UserModel userModel = userRepository.findByCpf(userCpf);
		if (!userModel.equals(null)) {
			return UserDTO.convert(userModel);
		}
		return null;
	}
	
	public List<UserDTO> qweryByName(String name) {
		List<UserModel> users = userRepository.queryByNameLike(name);

		// retorna uma lista que foi Transformada em um stream e foi chamado metodo map
		// para transformar a lista de entidades em uma lista de DTOs
		return users.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

}
