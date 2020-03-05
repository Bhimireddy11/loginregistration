package com.blz.demo.service;



import com.blz.demo.model.User;

public interface UserService {
	public boolean checkUser(String email, String pass);

	public boolean Register(User user);

}
	

