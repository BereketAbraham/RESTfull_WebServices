package edu.miu.rest.webservices.restfulwebservices.controller;

import edu.miu.rest.webservices.restfulwebservices.dao.UserDAO;
import edu.miu.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import edu.miu.rest.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDAO.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable Integer id){
		User user = userDAO.findOne(id);
		if(user == null)
			throw new UserNotFoundException("Id : " + id);
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("All-Users"));
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = userDAO.save(user);


		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deletetUser(@PathVariable Integer id){
		User user = userDAO.deleteById(id);
		if(user == null)
			throw new UserNotFoundException("Id : " + id);
	}
}
