package ptinews.dao.impl;

import java.util.List;

import ptinews.dao.IArticleDAO;
import ptinews.entity.ArticleEntity;
import ptinews.mapper.impl.ArticleMapper;

public class ArticleDAO extends BaseDAO<ArticleEntity> implements IArticleDAO {
	
	@Override
	public List<ArticleEntity> findAll() {
		StringBuilder sql = new StringBuilder("SELECT id, title, description, content, thumnail,");
		sql.append(" status, slug, created_date, last_modified, tbl_user_id, tbl_category_id, tbl_tag_id");
		sql.append(" FROM tbl_article");
		return find(sql.toString(), new ArticleMapper());
	}

	@Override
	public List<ArticleEntity> findByTitle(String title) {
		StringBuilder sql = new StringBuilder("SELECT id, title, description, content, thumnail,");
		sql.append(" status, slug, created_date, last_modified, tbl_user_id, tbl_category_id, tbl_tag_id");
		sql.append(" FROM tbl_article WHERE title LIKE ?");
		return find(sql.toString(), new ArticleMapper(), "%"+title+"%");
	}

	@Override
	public boolean save(ArticleEntity article, String username, String tagName, String categoryName) {
		StringBuilder sql = new StringBuilder("INSERT INTO tbl_article");
		sql.append(" (id, title, description, content, thumnail, status,");
		sql.append(" slug, created_date, last_modified, tbl_user_id, tbl_tag_id, tbl_category_id)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,"
				+ " (SELECT id FROM tbl_user WHERE username=?),"
				+ " (SELECT id FROM tbl_tag WHERE name=?),"
				+ " (SELECT id FROM tbl_category WHERE name=?))");
		int res = insert(sql.toString(), article.getId(), article.getTitle(), article.getDescription(), article.getContent(),
				article.getThumnail(), article.getStatus(), article.getSlug(), article.getCreatedDate(),
				article.getLastModified(), username, tagName, categoryName);
		if(res != 0) return true;
		return false;
	}


	@Override
	public boolean deleteArticle(String id) {
		StringBuilder sql = new StringBuilder("DELETE FROM tbl_article WHERE id=?");
		return update(sql.toString(), id);
	}
	
	@Override
	public boolean updateArticle(ArticleEntity article) {
		StringBuilder sql = new StringBuilder("UPDATE tbl_article ");
		sql.append("SET title=?, description=?, content=?, thumnail=?, slug=?" );
		sql.append("WHERE id=?");
		return update(sql.toString(), article.getTitle(), article.getDescription(), article.getContent(),
				article.getThumnail(), article.getSlug(), article.getId());
	}

	@Override
	public ArticleEntity findOne(String id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tbl_article WHERE id=?");
		List<ArticleEntity> list = find(sql.toString(), new ArticleMapper() , id);
		return (list.size() > 0) ? list.get(0) : null;
	}
}
