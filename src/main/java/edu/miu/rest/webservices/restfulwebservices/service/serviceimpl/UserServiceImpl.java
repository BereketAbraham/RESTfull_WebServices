package edu.miu.rest.webservices.restfulwebservices.service.serviceimpl;

import edu.miu.rest.webservices.restfulwebservices.model.User;
import edu.miu.rest.webservices.restfulwebservices.repository.UserRepository;
import edu.miu.rest.webservices.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findOne(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		 userRepository.deleteById(id);
	}
}
