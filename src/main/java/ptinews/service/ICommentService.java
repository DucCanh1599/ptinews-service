package ptinews.service;

import java.util.List;

import ptinews.entity.CommentEntity;

public interface ICommentService {
	List<CommentEntity> findByArticleId(String id);
	CommentEntity findOneById(String id);
	CommentEntity addNewComment(CommentEntity comment, String user, String articleId);
	CommentEntity deleteComment(String id);
	boolean updateComment(CommentEntity comment);
	boolean disableComment(CommentEntity comment);
}
