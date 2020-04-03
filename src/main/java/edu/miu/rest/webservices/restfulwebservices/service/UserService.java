package edu.miu.rest.webservices.restfulwebservices.service;

import edu.miu.rest.webservices.restfulwebservices.model.User;

import java.util.List;

public interface UserService {
	public List<User> findAll();
	public User save(User user);
	public User findOne(Integer id);
}
