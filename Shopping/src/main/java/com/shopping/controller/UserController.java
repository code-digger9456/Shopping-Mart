package com.shopping.controller;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.enumpackage.UserRole;
import com.shopping.model.User;
import com.shopping.service.UserService;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			User saveduser = userService.addOneUser(user);
			return new ResponseEntity<User>(saveduser, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<String>("User not added!!", HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable int id) {

		try {
			User getUser = userService.getOneUser(id);
			return new ResponseEntity<User>(getUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {

		try {
			userService.deleteUser(id);
			return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> editUser(@PathVariable int id, @RequestBody User user) {

		if (userService.updateUser(id, user).getId() > 0) {
			return new ResponseEntity<String>("User Successful Updated!!", HttpStatus.UPGRADE_REQUIRED);
		} else {
			return new ResponseEntity<String>("User not found!!", HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public ResponseEntity<?> displayUser() {
		try {
			List<User> allUsers = userService.displayAllUser();
			return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("User data not present", HttpStatus.BAD_GATEWAY);
		}

	}

	@PostConstruct
	public void initRoleAndUser() {
		userService.initRoleAndUser();
	}

}
