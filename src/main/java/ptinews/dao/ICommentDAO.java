package ptinews.dao;

import java.util.List;

import ptinews.entity.CommentEntity;

public interface ICommentDAO {
	CommentEntity findOneById(String id);
	List<CommentEntity> findByArticleId(String id);
	CommentEntity addNewComment(CommentEntity comment);
	CommentEntity deleteComment(String id);
	boolean updateComment(CommentEntity comment);
}
