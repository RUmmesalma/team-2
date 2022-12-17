package com.mkj.gtest.service;

import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.User;
import com.mkj.gtest.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		User savedUser =  userRepository.save(user);  // Note :  save() is already implemented by Spring Data JPA
		if(savedUser != null)
		{
			return savedUser;
		}
		else return null;
        }


	@Override
	public List<User> getAllUsers() throws Exception {
		
		// may contains other code like security , loggging , validation 
		
		List<User> allUsers =  userRepository.findAll(); // Note : same as save
		return allUsers;
	}
	@Override
	public User getUserByName(String userName) throws Exception{
		User output=userRepository.getUserByName(userName);
		return output;
	}
	@Override
	public List<User> getUserByRole(String role) throws Exception {
		List<User> outputuser=getAllUsers().stream().filter((user)->
			user.getRole().equals(role)).collect(Collectors.toList());
		
		return outputuser;
	}
	
	@Override
	public String deleteUser(String userName) throws Exception{
		User UserToBeDeleted=userRepository.getUserByName(userName);
		userRepository.delete(UserToBeDeleted);
		return "Deleted";
	}
}