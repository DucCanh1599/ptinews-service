package ptinews.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import ptinews.dao.ICategoryDAO;
import ptinews.dao.impl.CategoryDAO;
import ptinews.entity.CategoryEntity;
import ptinews.entity.UserEntity;
import ptinews.service.ICategoryService;
import ptinews.service.IUserService;

public class CategoryService implements ICategoryService {
	
	ICategoryDAO categoryDAO;
	IUserService userService;
	
	public CategoryService() {
		categoryDAO = new CategoryDAO();
		userService = new UserService();
	}

	@Override
	public List<CategoryEntity> findAll() {
		return null;
	}

	@Override
	public CategoryEntity findOneByName(String name) {
		return (name != null && !name.equals("")) ? categoryDAO.findOneByName(name) : null;
	}

	@Override
	public CategoryEntity findOneById(String id) {
		return (id != null && !id.equals("")) ? categoryDAO.findOneById(id) : null;
	}
	
	@Override
	public List<CategoryEntity> searchByName(String name) {
		return null;
	}

	@Override
	public boolean addCategory(CategoryEntity category) {
		category.setId(UUID.randomUUID().toString());
		category.setCreatedDate(new Date(System.currentTimeMillis()));
		category.setLastModified(new Date(System.currentTimeMillis()));
		UserEntity user = new UserEntity();
		user.setEmail("canhnd@gmail.com");
		user = userService.findOneByEmail(user);
		if(user != null) {
			category.setCreatedBy(user);
		}
		CategoryEntity dbCategory = findOneByName("sức khỏe");
		if(dbCategory != null) {
			category.setParentCategory(dbCategory);
		}
		String name = category.getName().toLowerCase();
		return (findOneByName(name) == null) ? categoryDAO.addCategory(category) : false;
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
