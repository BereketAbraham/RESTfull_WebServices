package edu.miu.rest.webservices.restfulwebservices.dao;

import edu.miu.rest.webservices.restfulwebservices.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDAO {

	private static int userCount = 6;
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "Bereket", new Date()));
		users.add(new User(2, "Genet", new Date()));
		users.add(new User(3, "Teklom", new Date()));
		users.add(new User(4, "Isaac", new Date()));
		users.add(new User(5, "Fiori", new Date()));
		users.add(new User(6, "Tesfit", new Date()));
	}
	public List<User> findAll(){
		return users;
	}

	public User save(User user){
		if(user.getId() == null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(Integer id){
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	public User deleteById(Integer id){
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()){
			User user = iterator.next();
			if(user.getId() == id){
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
