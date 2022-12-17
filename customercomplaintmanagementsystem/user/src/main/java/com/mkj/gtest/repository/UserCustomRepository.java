package com.mkj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkj.gtest.entity.User;

public interface UserCustomRepository {
	
	public User getUserByName(String userName)throws Exception;
	
}


// from Student where stream = :stream and loaction = :loaction
// stream and marks range 
// from stream and age and marks