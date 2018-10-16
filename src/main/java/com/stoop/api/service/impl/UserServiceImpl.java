package com.stoop.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.User;
import com.stoop.api.repository.UserRepository;
import com.stoop.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUser(String user) {
		return userRepository.findByUser(user);
	}

	public User registerUser(User user) {
		return userRepository.save(user);
	}

}
