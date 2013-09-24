package services;

import java.util.ArrayList;
import java.util.List;

import models.User;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;

import repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private Neo4jTemplate template;

	@Autowired
	private UserRepository userRepository;

	public long getNumberOfUsers() {
		return userRepository.count();
	}

	public List<User> getAllUsers() {
		return new ArrayList<User>(IteratorUtil.asCollection(userRepository.findAll()));
	}

	public List<User> makeSomeUsers() {
		List<User> users = new ArrayList<User>();

		users.add(createUser("Coco", "coco@mail.com", "coco"));
		users.add(createUser("Kiki", "kiki@mail.com", "kiki"));

		return users;
	}

	private User createUser(String name, String email, String password) {
		return userRepository.save(new User(name, email, password));
	}

	private Boolean authenticate(String email, String password) {
		User user = userRepository.findByPropertyValue("email", email);
		if (user.email.equals(password)) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}

}