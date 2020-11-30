package ptinews.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ptinews.dao.IBaseDAO;
import ptinews.mapper.RowMapper;
import ptinews.utils.DatabaseUtil;

public class BaseDAO<T> implements IBaseDAO<T> {

	Connection cnt = null;
	PreparedStatement stm = null;
	ResultSet resultSet = null;

	@Override
	public List<T> find(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		try {
			cnt = DatabaseUtil.getConnection();
			stm = cnt.prepareStatement(sql);
			setParameter(stm, parameters);
			resultSet = stm.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			close();
		}
	}

	@Override
	public boolean update(String sql, Object... parameters) {
		try {
			cnt = DatabaseUtil.getConnection();
			cnt.setAutoCommit(false);
			stm = cnt.prepareStatement(sql);
			setParameter(stm, parameters);
			stm.executeUpdate();
			cnt.commit();
			return true;
		} catch (SQLException e) {
			if (cnt != null) {
				try {
					cnt.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			close();
		}
		return false;
	}

	@Override
	public int insert(String sql, Object... parameters) {
		try {
			cnt = DatabaseUtil.getConnection();
			cnt.setAutoCommit(false);
			stm = cnt.prepareStatement(sql);
			setParameter(stm, parameters);
			int result = stm.executeUpdate();
			cnt.commit();
			return result;
		} catch (SQLException e) {
			if (cnt != null) {
				try {
					cnt.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return 0;
		} finally {
			close();
		}
	}
	
	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Date) {
					statement.setDate(index, (Date) parameter);
				} else if(parameter instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if (cnt != null) {
				cnt.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
