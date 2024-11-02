package com.example.grocery.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grocery.Model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
