package com.hcl.mybank.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.mybank.model.Role;
import com.hcl.mybank.model.User;

public class UserRowMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		Role role = new Role();
		
		role.setId(rs.getInt("role_id"));
		role.setRole(rs.getString("role"));
		
		user.setId(rs.getInt("user_id"));
		user.setActive(rs.getInt("active"));
		user.setEmail(rs.getString("email"));
		user.setLastName(rs.getString("last_name"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setRoles((Set<Role>) role);
		
		return user;
	}

}