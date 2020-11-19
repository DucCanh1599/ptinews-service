package ptinews.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ptinews.entity.UserEntity;
import ptinews.mapper.RowMapper;

public class UserMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs) {
		UserEntity user = new UserEntity();
		try {
			if(rs.getString("id") != null) {
				user.setId(rs.getString("id"));
			}
			if(rs.getString("username") != null) {
				user.setUsername(rs.getString("username"));
			}
			if(rs.getString("password") != null) {
				user.setPassword(rs.getString("password"));
			}
			if(rs.getString("email") != null) {
				user.setEmail(rs.getString("email"));
			}
			if(rs.getString("salt") != null) {
				user.setSalt(rs.getString("salt"));
			}
			if(rs.getBoolean("is_admin")) {
				user.setAdmin(rs.getBoolean("is_admin"));
			}
			if(rs.getBoolean("status")) {
				user.setStatus(rs.getBoolean("status"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
