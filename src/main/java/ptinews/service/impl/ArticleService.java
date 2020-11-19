package ptinews.service.impl;

import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import ptinews.dao.IArticleDAO;
import ptinews.dao.impl.ArticleDAO;
import ptinews.entity.ArticleEntity;
import ptinews.service.IArticleService;

public class ArticleService implements IArticleService {

	private IArticleDAO articleDAO;
	
	public ArticleService() {
		articleDAO = new ArticleDAO();
	}
	
	@Override
	public List<ArticleEntity> findAll() {
		return articleDAO.findAll();
	}
	
	@Override
	public List<ArticleEntity> search(String title) {
		return articleDAO.findByTitle(title);
	}

	@Override
	public boolean addNewArticle(ArticleEntity article, String username, String tagName, String categoryName) {
		article.setId(UUID.randomUUID().toString());
		article.setStatus(true);
		article.setCreatedDate(new Date(System.currentTimeMillis()));
		article.setLastModified(new Date(System.currentTimeMillis()));
		return articleDAO.save(article, username, tagName, categoryName);
	}

	@Override
	public boolean deleteArticle(String encodedId) {
		byte[] byteId = Base64.getDecoder().decode(encodedId);
		String id = new String(byteId);
		if(id != null && !id.isEmpty()) {
			if(findOne(id) != null) {
				return articleDAO.deleteArticle(id);
			}
		}
		return false;
	}

	@Override
	public boolean updateArticle(ArticleEntity article, String encodedId) {
		byte[] byteId = Base64.getDecoder().decode(encodedId);
		String id = new String(byteId);
		if(id != null && !id.isEmpty()) {
			if(findOne(id) != null) {
				article.setId(id);
				return articleDAO.updateArticle(article);
			}
		}
		return false;
	}

	@Override
	public ArticleEntity findOne(String id) {
		return articleDAO.findOne(id);
	}
}
