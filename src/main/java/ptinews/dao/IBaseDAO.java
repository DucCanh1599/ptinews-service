package ptinews.dao;

import java.util.List;

import ptinews.mapper.RowMapper;

public interface IBaseDAO<T> {
	
	List<T> find(String sql, RowMapper<T> rowMapper, Object... parameters);

	boolean update(String sql, Object... parameters);
	
	int insert(String sql, Object... parameters);
}
