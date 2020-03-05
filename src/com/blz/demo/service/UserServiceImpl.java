package com.blz.demo.service;

import com.blz.demo.model.User;
import com.blz.demo.repo.UserRepo;

public class UserServiceImpl implements UserService {
	private UserRepo repo;

	@Override
	public boolean checkUser(String email, String pass) {
		repo = new UserRepo();
		if(!repo.validateUser(email, pass)) {
			return false;}
		else{
		return true;
		}
		
	}

	@Override
	public boolean Register(User user) {
		repo = new UserRepo();
		if (repo.register(user))
			return true;
		return false;
	}
}
