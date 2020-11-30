package ptinews.service;

import ptinews.entity.UserEntity;

public interface IUserService {
	UserEntity checkLogin(UserEntity user);
	void addUser(String username, String password, String email);
	UserEntity findOneByEmail(UserEntity user);
	UserEntity findOneById(String id);
}
