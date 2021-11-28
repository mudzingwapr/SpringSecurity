package com.mudzingwa.sec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudzingwa.sec.model.User;
import com.mudzingwa.sec.repo.UserRepo;
@Service
public class UserInterfeImpl implements UserInterf {
	@Autowired
	private UserRepo repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User findUser(Integer uid) {
		return repo.findById(uid).get();
	}

	@Override
	public void DeleteUser(Integer uid) {
		repo.deleteById(uid);

	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

}
