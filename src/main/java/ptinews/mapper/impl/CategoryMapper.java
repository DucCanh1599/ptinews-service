package ptinews.mapper.impl;

import java.sql.ResultSet;

import ptinews.entity.CategoryEntity;
import ptinews.entity.UserEntity;
import ptinews.mapper.RowMapper;
import ptinews.service.ICategoryService;
import ptinews.service.IUserService;
import ptinews.service.impl.CategoryService;
import ptinews.service.impl.UserService;

public class CategoryMapper implements RowMapper<CategoryEntity> {

	IUserService userService;
	ICategoryService categoryService;

	public CategoryMapper() {
		userService = new UserService();
		categoryService = new CategoryService();
	}

	@Override
	public CategoryEntity mapRow(ResultSet rs) {
		CategoryEntity category = new CategoryEntity();
		try {
			if (rs.getString("id") != null) {
				category.setId(rs.getString("id"));
			}
			if (rs.getString("name") != null) {
				category.setName(rs.getString("name"));
			}
			if (rs.getString("description") != null) {
				category.setDescription(rs.getString("description"));
			}
			if (rs.getBoolean("status")) {
				category.setStatus(rs.getBoolean("status"));
			}
			if (rs.getString("slug") != null) {
				category.setSlug(rs.getString("slug"));
			}
			if (rs.getDate("created_date") != null) {
				category.setCreatedDate(rs.getDate("created_date"));
			}
			if (rs.getDate("last_modified") != null) {
				category.setCreatedDate(rs.getDate("last_modified"));
			}
			if (rs.getString("tbl_user_id") != null) {
				UserEntity user = userService.findOneById(rs.getString("tbl_user_id"));
				category.setCreatedBy(user);
			}
			if (rs.getString("parent_id") != null) {
				CategoryEntity parentCategory = categoryService.findOneById(rs.getString("parent_id"));
				category.setParentCategory(parentCategory);
			}
			return category;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
