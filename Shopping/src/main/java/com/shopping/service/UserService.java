package com.shopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shopping.model.User;


public interface UserService {

	
	User addOneUser(User user);
	
	User getOneUser(int id);

	void deleteUser(int id);
	
	User updateUser(int id, User user);
	
	List<User> displayAllUser();

	ResponseEntity<String> initRoleAndUser();

}
