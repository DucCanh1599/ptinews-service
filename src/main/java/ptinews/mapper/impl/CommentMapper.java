package ptinews.mapper.impl;

import java.sql.ResultSet;

import ptinews.entity.CommentEntity;
import ptinews.mapper.RowMapper;

public class CommentMapper implements RowMapper<CommentEntity> {

	@Override
	public CommentEntity mapRow(ResultSet rs) {
		CommentEntity entity = new CommentEntity();
		try {
			if(rs.getString("id") != null) {
				entity.setId(rs.getString("id"));
			}
			if(rs.getString("content") != null) {
				entity.setContent(rs.getString("content"));
			}
			if(rs.getBoolean("status")) {
				entity.setStatus(rs.getBoolean("status"));
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
			if(rs.getString("tbl_article_id") != null) {
				entity.setArticleId(rs.getString("tbl_article_id"));
			}
			return entity;
		} catch (Exception e) {
		}
		return null;
	}

}
