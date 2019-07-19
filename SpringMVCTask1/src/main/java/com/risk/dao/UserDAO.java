package com.risk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.risk.model.User;

@Repository
public class UserDAO {
	
private static List<User> list = null;
	static{
		list = new ArrayList<User>();
		list.add(new User("sudarshan", 30, "1@gmail.com", "India"));
		list.add(new User("kumar", 40, "2@gmail.com", "India"));
		list.add(new User("Thakur", 30, "3@gmail.com", "India"));
	}
	public List<User> getUserList() {
		return list;
	}
	public void addUser(User user) {
		list.add(user);
	}
}
