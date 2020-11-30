package ptinews.dao.impl;

import java.util.List;

import ptinews.dao.ICategoryDAO;
import ptinews.entity.CategoryEntity;
import ptinews.mapper.impl.CategoryMapper;

public class CategoryDAO extends BaseDAO<CategoryEntity> implements ICategoryDAO {
	
	@Override
	public List<CategoryEntity> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM tbl_category");
		return find(sql.toString(), new CategoryMapper());
	}

	@Override
	public CategoryEntity findOneById(String id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tbl_category WHERE id = ?");
		return find(sql.toString(), new CategoryMapper(), id).get(0);
	}

	@Override
	public CategoryEntity findOneByName(String name) {
		StringBuilder sql = new StringBuilder("SELECT id, name, description, status, slug, created_date, last_modified, tbl_user_id, parent_id ");
		sql.append("FROM tbl_category WHERE name = ?");
		List<CategoryEntity> list = find(sql.toString(), new CategoryMapper(), name);
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<CategoryEntity> searchByName(String name) {
		return null;
	}

	@Override
	public boolean addCategory(CategoryEntity category) {
		StringBuilder  sql = new StringBuilder("INSERT INTO tbl_category ");
		sql.append("(id, name, description, status, slug, created_date, last_modified, tbl_user_id, parent_id) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?");
		int isInserted = insert(sql.toString(), category.getId(), category.getName().toLowerCase(), category.getDescription(),
				category.getStatus(), category.getSlug(), category.getCreatedDate(), category.getLastModified(),
				category.getCreatedBy().getId(), category.getParentCategory().getId());
		return (isInserted == 1) ? true : false;
	}

	@Override
	public boolean deleteCategory(CategoryEntity category) {
		return false;
	}

	@Override
	public boolean updateCategory(CategoryEntity category, String encodedId) {
		return false;
	}

}
