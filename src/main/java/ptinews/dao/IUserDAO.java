package ptinews.dao;

import ptinews.entity.UserEntity;

public interface IUserDAO {
	UserEntity checkLogin(String email, String password);
	void save(UserEntity user);
	UserEntity findOneByEmail(UserEntity user);
}
