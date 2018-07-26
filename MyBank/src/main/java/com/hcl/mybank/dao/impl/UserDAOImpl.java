package com.hcl.mybank.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dao.UserDAO;
import com.hcl.mybank.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String FETCH_USER_BYID_STATUS = "SELECT * FROM User where user_id = ?";
	private static final String DUPLICATE_USER_CHK="SELECT * FROM User where email_id = ? or (upper(last_name)=upper(?))";
	private static final String UPDATE_USER_STATUS = "update user set email = ? where user_id = ?";
	private static final String INSERT_USER = "INSERT INTO USER(user_id,active,email,last_name,name,password) VALUES(?,?,?,?,?,?)";
	private static final String SELECT_MAX_USERID = "select max(user_id) from user";
	private static final String DELETE_USER= "DELETE from user where user_id= ?";

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Resource
	private Environment env;

	// Constructor -initiates jdbcTemplate
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User fetchUser(long userId) {

		logger.debug("fetchUser(id) - Method Input - " + userId);

		User user = jdbcTemplate.queryForObject(FETCH_USER_BYID_STATUS, new Object[] { userId},
				new UserRowMapper());
		return user;
	}

	
	@Override
	public User updateUser(long userId, User user) {

		logger.debug("updateUser(id) - Method Input - UserId: " + userId + " User: " + user);
		int userCount = -1;
		try {
			userCount = jdbcTemplate.update(UPDATE_USER_STATUS, user.getEmail(), userId);
			logger.debug("updateUser(id) - Method Input - UserId: " + userId + " User: " + user
					+ "updated successfully " + userCount);
		} catch (DataAccessException dae) {
			logger.error("Unable to update user mail with User-Id: " + userId, dae);
		}
		if (userCount > 0)
			return user;

		return new User();
	}

	@Override
	public int persistUser(User user) {

		int userCount = -1;
		logger.debug("persistUser(id) - Method Input - User: " + user);

		try {
			userCount = jdbcTemplate.update(INSERT_USER, user.getActive(),user.getEmail(),user.getId(),user.getLastName(),
					user.getName(),user.getPassword(),user.getRoles());

			logger.debug("persistUser(id) - User persisted with Status : " + userCount);

			String userId = jdbcTemplate.queryForObject(SELECT_MAX_USERID, String.class);
			user.setId(Integer.parseInt(userId));
			logger.debug("persistUser(id) - User persisted with User Id : " + userId);

		
		} catch (DataAccessException dae) {
			logger.error(dae);
		}

		return userCount;

	}

	
	@Override
	public void deleteUser(long userId) {

		logger.debug("deleteUser(id) - Method Input - UserId: " + userId);
		int count = 0;
		try {
			count = jdbcTemplate.update(DELETE_USER, userId);
		} catch (DataAccessException dae) {
			logger.error(dae);
		}
		logger.debug("deleteUser(id) status: " + count);
	}

	@Override
	public boolean existingUserCheck(User user) {

		if (user == null) {
			return false;
		} else {

			List lst = jdbcTemplate.query(DUPLICATE_USER_CHK,
					new Object[] { user.getEmail(), user.getLastName() },
					new UserRowMapper());
			if (lst.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

	}

}
