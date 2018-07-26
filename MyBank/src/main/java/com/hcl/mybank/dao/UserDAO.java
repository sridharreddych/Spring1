package com.hcl.mybank.dao;

import com.hcl.mybank.model.User;

public interface UserDAO {

	public User fetchUser(long userId);	
	public User updateUser(long userId, User user);
	 
	public int persistUser(User user);
	
	public void deleteUser(long userId);
	
	public boolean existingUserCheck(User user);
	
}
