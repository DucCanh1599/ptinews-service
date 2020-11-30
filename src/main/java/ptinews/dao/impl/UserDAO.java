package ptinews.dao.impl;

import ptinews.dao.IUserDAO;
import ptinews.entity.UserEntity;
import ptinews.mapper.impl.UserMapper;

public class UserDAO extends BaseDAO<UserEntity> implements IUserDAO {

	@Override
	public UserEntity checkLogin(String email, String password) {
		return null;
	}

	@Override
	public void save(UserEntity user) {
		StringBuilder sql = new StringBuilder("INSERT INTO tbl_user");
		sql.append(" (id, username, password, salt, email,");
		sql.append(" is_admin, status, created_date, created_by, last_modified)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		insert(sql.toString(), user.getId(), user.getUsername(), user.getPassword(), user.getSalt(),
				user.getEmail(), user.getIsAdmin(), user.getStatus(), user.getCreatedDate(),
				user.getCreatedBy().getId(), user.getLastModified());
	}

	@Override
	public UserEntity findOneByEmail(UserEntity user) {
		StringBuilder sql = new StringBuilder("SELECT id, username, password, salt, email,");
		sql.append(" is_admin, status, created_date, created_by, last_modified");
		sql.append(" FROM tbl_user WHERE email = ?");
		user = find(sql.toString(), new UserMapper(), user.getEmail()).get(0);
		return user;
	}

	@Override
	public UserEntity findOneById(String id) {
		StringBuilder sql = new StringBuilder("SELECT id, username, password, salt, email,");
		sql.append(" is_admin, status, created_date, created_by, last_modified");
		sql.append(" FROM tbl_user WHERE id = ?");
		return find(sql.toString(), new UserMapper(), id).get(0);
	}
}
