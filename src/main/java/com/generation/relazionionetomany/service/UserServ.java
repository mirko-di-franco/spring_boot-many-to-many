package com.generation.relazionionetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.relazionionetomany.entity.User;
import com.generation.relazionionetomany.repository.UserRepo;

@Service
public class UserServ {

	@Autowired
	UserRepo userRepo;
	
	public List<User> all(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	
	public User addOrModify(User user){
		User newUser = userRepo.save(user);
		return null;
	}
	
	
	public Optional<User> getById(int userId){
		Optional<User> user = userRepo.findById(userId);
		return user;
	}
	
}
