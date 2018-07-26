 package com.hcl.mybank.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dao.UserLoginDAO;
import com.hcl.mybank.model.Role;
import com.hcl.mybank.model.User;


public class UserLoginDAOImpl implements UserLoginDAO {

	JdbcTemplate jdbcTemplate;

	public UserLoginDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User validateLoginUser(User user) {
		return this.jdbcTemplate.queryForObject(
				"select user_id, email_id, role_id, password from user where email_id = ?",
				new Object[] { user.getEmail() }, new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						Role role = new Role();
						role.setId(rs.getInt("role_id"));
						role.setRole(rs.getString("role"));
						user.setId(rs.getInt("user_id"));
						user.setEmail(rs.getString("email_id"));
						user.setRoles((Set<Role>) role);
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
	}
}
