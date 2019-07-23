package com.risk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.risk.model.User;


@Repository
public interface UserDao {

	public abstract List<User> getUserList();
	public abstract void addUserList(User user);

}
