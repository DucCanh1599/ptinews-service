package ptinews.dao;

import java.util.List;

import ptinews.entity.ArticleEntity;

public interface IArticleDAO {
	List<ArticleEntity> findAll();
	ArticleEntity findOne(String id);
	List<ArticleEntity> findByTitle(String title);
	boolean save(ArticleEntity article, String username, String tagName, String categoryName);
	boolean deleteArticle(String id);
	boolean updateArticle(ArticleEntity article);
}
