package com.risk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.risk.dao.UserDao;
import com.risk.model.User;
import com.risk.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public void addUserList(User user) {
		userDao.addUserList(user);
	}

}
