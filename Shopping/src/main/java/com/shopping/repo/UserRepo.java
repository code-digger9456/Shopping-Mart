package com.shopping.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	

	Optional<User> findByEmail(String string);
}
