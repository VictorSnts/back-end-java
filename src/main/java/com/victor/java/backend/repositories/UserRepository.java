package com.victor.java.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.java.backend.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {


	UserModel findByCpf(String cpf);
    List<UserModel> queryByNameLike(String name);
    
}