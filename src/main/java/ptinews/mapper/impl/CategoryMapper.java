package ptinews.mapper.impl;

import java.sql.ResultSet;

import ptinews.entity.CategoryEntity;
import ptinews.mapper.RowMapper;

public class CategoryMapper implements RowMapper<CategoryEntity> {

	@Override
	public CategoryEntity mapRow(ResultSet rs) {
		CategoryEntity category = new CategoryEntity();
		try {
			if(rs.getString("id") != null) {
				category.setId(rs.getString("id"));
			}
			if(rs.getString("name") != null) {
				category.setName(rs.getString("name"));
			}
			if(rs.getString("description") != null) {
				category.setDescription(rs.getString("description"));
			}
			if(rs.getBoolean("status")) {
				category.setStatus(rs.getBoolean("status"));
			}
			if(rs.getString("slug") != null) {
				category.setSlug(rs.getString("slug"));
			}
			if(rs.getDate("created_date") != null) {
				category.setCreatedDate(rs.getDate("created_date"));
			}
			if(rs.getDate("last_modified") != null) {
				category.setCreatedDate(rs.getDate("last_modified"));
			}
		} catch (Exception e) {
		}
		return null;
	}
}
