package models;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class User {

	@GraphId
	public Long id;

	@Indexed
	public String name;

	@Indexed(indexName = "email-index")
	public String email;

	public String password;

	public User() {
		super();
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("User{name='%s', email=%s}", name, email);
	}

}