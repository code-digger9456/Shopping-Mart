package com.shopping.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.enumpackage.UserRole;
import com.shopping.model.User;
import com.shopping.repo.UserRepo;
import com.shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public User addOneUser(User user) {
				
//		return userRepo.save(user);
		
        User u1 = new User();
		
		u1.setName(user.getName());
		u1.setEmail(user.getEmail());
		u1.setMobile(user.getMobile());	
	    u1.setRole(UserRole.USER);
	    u1.setPassword(user.getPassword());
		
		return userRepo.save(u1);

				
	}


	@Override
	public User getOneUser(int id) {
		
		return userRepo.findById(id).get();
	}


	@Override
	public void deleteUser(int id) {
		
	 User user = userRepo.findById(id).get();
	 userRepo.delete(user);
		
	}


	@Override
	public User updateUser(int id, User u) {
		
		User existUser = userRepo.findById(id).get();
		
		existUser.setName(u.getName());
		existUser.setEmail(u.getEmail());
		existUser.setMobile(u.getMobile());	
		existUser.setPassword(u.getPassword());
		existUser.setRole(u.getRole());
		
		return userRepo.save(existUser);
	
	}
	
	public List<User> displayAllUser()
	{
		List<User> users = userRepo.findAll();
		
		return users;
	}

  // check for user 
	
	@Override
	public ResponseEntity<String> initRoleAndUser() {
		
			// check if user already exist. if exist than authenticate the user
			if (userRepo.findByEmail("admin@example.com").isPresent()) {
				return new ResponseEntity<String>("User already exist",HttpStatus.ALREADY_REPORTED);
			}
			else {
				//If user is not present then create a new user
				User user = new User();
				user.setName("Admin");
				user.setEmail("admin@example.com");
				user.setMobile(98765544);
				user.setPassword("admin");
				user.setRole(UserRole.ADMIN);//

				user = userRepo.save(user);
				
				return new ResponseEntity<String>("Admin registration was successful",HttpStatus.OK);
			
			}
			
		
	}



}
