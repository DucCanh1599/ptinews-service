package ptinews.dao.impl;

import java.util.List;

import ptinews.dao.ICommentDAO;
import ptinews.entity.CommentEntity;
import ptinews.mapper.impl.CommentMapper;

public class CommentDAO extends BaseDAO<CommentEntity> implements ICommentDAO {
	
	@Override
	public CommentEntity findOneById(String id) {
		StringBuilder sql = new StringBuilder("SELECT id, content, status, created_date, last_modified,");
		sql.append(" tbl_user_id, tbl_article_id FROM tbl_comment WHERE id=?");
		return find(sql.toString(), new CommentMapper(), id).get(0);
	}

	@Override
	public List<CommentEntity> findByArticleId(String id) {
		StringBuilder sql = new StringBuilder("SELECT id, content, status, created_date, last_modified,");
		sql.append(" tbl_user_id, tbl_article_id FROM tbl_comment WHERE tbl_article_id = ?");
		return find(sql.toString(), new CommentMapper(), id);
	}

	@Override
	public CommentEntity addNewComment(CommentEntity comment) {
		StringBuilder sql = new StringBuilder("INSERT INTO tbl_comment");
		sql.append(" (id, content, status, created_date, last_modified, tbl_user_id, tbl_article_id)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		int res = insert(sql.toString(), comment.getId(), comment.getContent(), comment.getStatus(),
					comment.getCreatedDate(), comment.getLastModified(), comment.getUserId(),
					comment.getArticleId());
		if(res == 1) return findOneById(comment.getId());
		return null;
	}

	@Override
	public boolean deleteComment(String id) {
		StringBuilder sql = new StringBuilder("DELETE FROM tbl_comment WHERE id = ?");
		return update(sql.toString(), id);
	}

	@Override
	public boolean updateComment(CommentEntity comment) {
		StringBuilder sql = new StringBuilder("UPDATE tbl_comment ");
		sql.append("SET content=?, status=?, last_modified=?, article_id=? ");
		sql.append("WHERE id=? AND user_id=?");
		return update(sql.toString(), comment.getContent(), comment.getStatus(), 
				comment.getLastModified(), comment.getArticleId(), comment.getUserId());
	}
}
