package com.einfochips.rest.webservices.restfullwebservices.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	@Autowired
	private UserRepositry userRepositry;

	// find all users
	public List<User> findAll() {
		return userRepositry.findAll();
	}

	// find specific user

	public Optional<User> findOne(Long id) {
		return userRepositry.findById(id);

	}

	//save user 
	public User saveUser(User user) {
		return userRepositry.save(user);
	}

	public void deleteUser(Long id) {
		userRepositry.deleteById(id);	
	}
}
