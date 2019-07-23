package com.risk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.risk.model.User;

@Service
public interface UserService {

	
	public abstract List<User> getUserList() ;
	public abstract void addUserList(User user) ;

}
