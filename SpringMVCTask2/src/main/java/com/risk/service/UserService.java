package com.risk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.risk.dao.UserDao;
import com.risk.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public void addUserList(User user) {
		userDao.addUserList(user);
	}

}
