package ptinews.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ptinews.entity.ArticleEntity;
import ptinews.mapper.RowMapper;

public class ArticleMapper implements RowMapper<ArticleEntity> {

	@Override
	public ArticleEntity mapRow(ResultSet rs) {
		ArticleEntity entity = new ArticleEntity();
		try {
			if(rs.getString("id") != null) {
				entity.setId(rs.getString("id"));
			}
			if(rs.getString("title") != null){
				entity.setTitle(rs.getString("title"));
			}
			if(rs.getString("description") != null) {
				entity.setDescription(rs.getString("description"));
			}
			if(rs.getString("content") != null) {
				entity.setContent(rs.getString("content"));
			}
			if(rs.getString("thumnail") != null) {
				entity.setThumnail(rs.getString("thumnail"));
			}
			if(rs.getBoolean("status")) {
				entity.setStatus(rs.getBoolean("status"));
			}
			if(rs.getString("slug") != null) {
				entity.setSlug(rs.getString("slug"));
			}
			if(rs.getDate("created_date") != null) {
				entity.setCreatedDate(rs.getDate("created_date"));
			}
			if(rs.getDate("last_modified") != null) {
				entity.setLastModified(rs.getDate("last_modified"));
			}
			if(rs.getString("tbl_user_id") != null) {
				entity.setUserId(rs.getString("tbl_user_id"));
			}
			if(rs.getString("tbl_tag_id") != null) {
				entity.setTagId(rs.getString("tbl_tag_id"));
			}
			if(rs.getString("tbl_category_id") != null) {
				entity.setCategoryId(rs.getString("tbl_category_id"));
			}
			return entity;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
