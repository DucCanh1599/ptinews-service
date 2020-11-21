package ptinews.service.impl;

import java.util.List;

import ptinews.entity.CategoryEntity;
import ptinews.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Override
	public List<CategoryEntity> findAll() {
		return null;
	}

	@Override
	public CategoryEntity findOneByName(String name) {
		return null;
	}

	@Override
	public List<CategoryEntity> searchByName(String name) {
		return null;
	}

	@Override
	public boolean addCategory(CategoryEntity category) {
		return false;
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
