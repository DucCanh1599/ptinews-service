package ptinews.service;

import java.util.List;

import ptinews.entity.ArticleEntity;

public interface IArticleService {
	List<ArticleEntity> findAll();
	ArticleEntity findOne(String id);
	List<ArticleEntity> search(String title);
	boolean addNewArticle(ArticleEntity article, String username, String tagName, String categoryName);
	boolean deleteArticle(String encodedId);
	boolean updateArticle(ArticleEntity article, String encodedId);
}
