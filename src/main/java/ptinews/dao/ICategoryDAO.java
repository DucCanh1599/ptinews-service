package ptinews.dao;

import java.util.List;

import ptinews.entity.CategoryEntity;

public interface ICategoryDAO {
	List<CategoryEntity> findAll();
	CategoryEntity findOneById(String id);
	CategoryEntity findOneByName(String name);
	List<CategoryEntity> searchByName(String name);
	boolean addCategory(CategoryEntity category);
	boolean deleteCategory(CategoryEntity category);
	boolean updateCategory(CategoryEntity category, String encodedId);
}
