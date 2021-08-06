package com.victor.backend.user_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.backend.user_api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	User findByCpf(String cpf);
    List<User> queryByNameLike(String name);
    
}