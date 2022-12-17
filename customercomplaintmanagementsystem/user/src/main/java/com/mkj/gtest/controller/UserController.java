package com.mkj.gtest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtest.entity.User;
import com.mkj.gtest.service.UserService;


@RestController
@RequestMapping("/User1")
public class UserController {
      
	@Autowired
	UserService userService;
	public UserController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}

	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
		try {
			User savedUser =  userService.insertUser(user);
			String responseMsg = savedUser.getUserName()+" save with Id "+savedUser.getUserId();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- customercomplaintmanagementsystem.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/user/role/{searchrole}")
	public List<User> getByRole(@PathVariable String searchrole)throws Exception
	{
		List<User> user=userService.getUserByRole(searchrole);
		return user;
	}
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		// write some code to extract users
		try {
			List<User>  allExtractedUsers = userService.getAllUsers();
			
			return allExtractedUsers;
			
		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);
			
		}
		
		return null;
	}
	@GetMapping("\"/user/{searchUsername}\"")
	public ResponseEntity<String> delete(@PathVariable String searchUsername){
		try {
			
			userService.deleteUser(searchUsername);
			String responseMsg="User is deleted";
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}