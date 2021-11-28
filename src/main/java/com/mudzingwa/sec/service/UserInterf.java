package com.mudzingwa.sec.service;

import java.util.List;

import com.mudzingwa.sec.model.User;

public interface UserInterf {
	public User addUser(User user);
	public User findUser(Integer uid);
	public void DeleteUser(Integer uid);
	public List<User> findAll();

}
