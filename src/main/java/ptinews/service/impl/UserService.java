package ptinews.service.impl;

import java.sql.Date;
import java.util.UUID;

import ptinews.dao.IUserDAO;
import ptinews.dao.impl.UserDAO;
import ptinews.entity.UserEntity;
import ptinews.service.IUserService;
import ptinews.utils.PasswordUtil;

public class UserService implements IUserService {

	IUserDAO userDao;

	public UserService() {
		userDao = new UserDAO();
	}

	@Override
	public UserEntity checkLogin(UserEntity user) {
		UserEntity clientUser = user;
		if (user.getEmail() != null && !user.getEmail().isEmpty()) {
			UserEntity dbUser = findOneByEmail(user);
			String salt = dbUser.getSalt();
			String userPassword = clientUser.getPassword();
			String dbHasedPassword = dbUser.getPassword();
			String userHasedPassword = PasswordUtil.getPassword(userPassword.toCharArray(), salt.getBytes());
			if (dbHasedPassword.equals(userHasedPassword)) {
				return dbUser;
			}
		}
		return null;
	}

	@Override
	public void addUser(String username, String password, String email) {
		String salt = PasswordUtil.getSalt();
		String hasedPassword = PasswordUtil.getPassword(password.toCharArray(), salt.getBytes());

		UserEntity user = new UserEntity();
		user.setId(UUID.randomUUID().toString());
		user.setUsername(username);
		user.setEmail(email);
		user.setSalt(salt);
		user.setPassword(hasedPassword);
		user.setAdmin(false);
		user.setStatus(true);
		user.setCreatedDate(new Date(System.currentTimeMillis()));
//		user.setCreatedBy(user.getId());
		user.setLastModified(new Date(System.currentTimeMillis()));

		if (user.getId() != null && user.getEmail() != null && user.getPassword() != null) {
			userDao.save(user);
		}
	}

	@Override
	public UserEntity findOneByEmail(UserEntity user) {
		return userDao.findOneByEmail(user);
	}

	@Override
	public UserEntity findOneById(String id) {
		return null;
	}
}
