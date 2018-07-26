package com.hcl.mybank.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.mybank.dao.RoleRepository;
import com.hcl.mybank.dao.UserDAO;
import com.hcl.mybank.dao.UserRepository;
import com.hcl.mybank.exception.UserAlreadyExist;
import com.hcl.mybank.model.Role;
import com.hcl.mybank.model.User;
import com.hcl.mybank.service.UserService;


@PropertySource("classpath:error.properties")
//@Service
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserDAO userDao;

	@Autowired
	Environment env;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
   /* @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	@Override
	public User fetchUser(long userId) {

		logger.debug("fetchUser(id) - Method Input - Id:" + userId);

		User fetchedUser = userDao.fetchUser(userId);
		logger.debug("updateUser(id, user) - Method Output - Fetched User:" + fetchedUser);

		return fetchedUser;
	}

	@Override
	public User updateUser(long userId, User user) {

		logger.debug("updateUser(id, user) - Method Input - ID:" + userId + "User:" + user);
		User updateUser = userDao.updateUser(userId, user);
		logger.debug("updateUser(id, user) - Method Output - Updated User:" + updateUser);

		return updateUser;
	}

	@Transactional
	@Override
	public int persistUser(User user) {
		
		int insertedRecordCount = -1;
		logger.debug("persistUser(id) - Method Input - User:" + user);
		if (!userDao.existingUserCheck(user)) {
			/*user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setActive(1);
	        Role userRole = roleRepository.findByRole("ADMIN");
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));*/
			insertedRecordCount = userDao.persistUser(user);
			logger.debug("persistedUser(user) - Method Output - Inserted Record Count:" + insertedRecordCount);
		}else {
			throw new UserAlreadyExist(env.getProperty("LMS.USER.USER_ALREADY_EXIST"));
		}
		return insertedRecordCount;
	}

	@Override
	public void deleteUser(long userId) {
		userDao.deleteUser(userId);
	}

	

}
