package com.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.userservice.custom.exception.UserNotFound;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int saveUser(User user)
	{
		int id = userRepository.save(user).getId();
		return id ;
	}
	
	public List<User> getAllUser()
	{
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public User getUserById(int id)
	{
		Optional<User> opt=  userRepository.findById(id);
		User user=opt.orElseThrow(()-> new UserNotFound("User Not Found"));
		
		return user;
	}
	
		
	public void deleteUser(int id)
	{
		User user = getUserById(id);
		userRepository.delete(user);
	}
	

}
