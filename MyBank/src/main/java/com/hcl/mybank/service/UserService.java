package com.hcl.mybank.service;

import com.hcl.mybank.model.User;

public interface UserService {

	public User fetchUser(long userId);	
	public User updateUser(long userId, User user);
	 
	public int persistUser(User user);
	
	public void deleteUser(long userId);
	
	
}
