package ptinews.service;

import java.util.List;

import ptinews.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryEntity> findAll();
	CategoryEntity findOneByName(String name);
	List<CategoryEntity> searchByName(String name);
	boolean addCategory(CategoryEntity category);
	boolean deleteCategory(CategoryEntity category);
	boolean updateCategory(CategoryEntity category, String encodedId);
}
