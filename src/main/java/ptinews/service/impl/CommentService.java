package ptinews.service.impl;

import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import ptinews.dao.ICommentDAO;
import ptinews.dao.impl.CommentDAO;
import ptinews.entity.CommentEntity;
import ptinews.entity.UserEntity;
import ptinews.service.ICommentService;
import ptinews.service.IUserService;

public class CommentService implements ICommentService {
	
	IUserService userService;
	ICommentDAO commentDAO;
	
	public CommentService() {
		userService = new UserService();
		commentDAO = new CommentDAO();
	}

	@Override
	public List<CommentEntity> findByArticleId(String encodedId) {
		byte[] byteId = Base64.getDecoder().decode(encodedId);
		String id = new String(byteId);
		if(id != null && !id.isEmpty()) {
			return commentDAO.findByArticleId(id);
		}
		return null;
	}

	@Override
	public CommentEntity addNewComment(CommentEntity comment, String userEmail, String articleId) {
		UserEntity user = new UserEntity();
		user.setEmail(userEmail);
		user = userService.findOneByEmail(user);
		if(user != null) {
			comment.setUserId(user.getId());
			comment.setArticleId(articleId);
		}
		comment.setId(UUID.randomUUID().toString());
		comment.setCreatedDate(new Date(System.currentTimeMillis()));
		comment.setLastModified(new Date(System.currentTimeMillis()));
		return commentDAO.addNewComment(comment);
	}
	
	@Override
	public boolean deleteComment(String encodedId) {
		byte[] byteId = Base64.getDecoder().decode(encodedId);
		String id = new String(byteId);
		if(id != null && !id.isEmpty()) {
			if(findOneById(id) != null) {
				return commentDAO.deleteComment(id);
			}
		}
		return false;
	}

	@Override
	public boolean updateComment(CommentEntity comment) {
		if(comment != null) {
			commentDAO.updateComment(comment);
		}
		return false;
	}

	@Override
	public boolean disableComment(CommentEntity comment) {
		return false;
	}

	@Override
	public CommentEntity findOneById(String id) {
		if(id != null && !id.isEmpty()) {
			return commentDAO.findOneById(id);
		}
		return null;
	}
}
