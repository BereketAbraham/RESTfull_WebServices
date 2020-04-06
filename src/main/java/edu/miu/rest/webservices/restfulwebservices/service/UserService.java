package edu.miu.rest.webservices.restfulwebservices.service;

import edu.miu.rest.webservices.restfulwebservices.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	public List<User> findAll();
	public User save(User user);
	public Optional<User> findOne(Integer id);
	public void deleteById(Integer id);
}
