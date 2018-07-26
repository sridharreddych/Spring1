package com.hcl.mybank.dao;

import com.hcl.mybank.model.User;

public interface UserLoginDAO {

	User validateLoginUser(User user);

}
