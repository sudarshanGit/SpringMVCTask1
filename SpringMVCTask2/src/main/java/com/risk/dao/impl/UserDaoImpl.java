package com.risk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.risk.dao.UserDao;
import com.risk.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	private static List<User> list = null;

	static {
		list = new ArrayList<User>();
		list.add(new User("KK", 30, "kk.cs@gmail.com", "India","8095801093"));
		list.add(new User("Martin", 40, "martin.cs@gmail.com", "US","8095801093"));
		list.add(new User("Sean", 30, "sean.cs@gmail.com", "Canada","8095801093"));
	}

	public List<User> getUserList() {
		return list;
	}

	public void addUserList(User user) {
		list.add(user);
	}

}