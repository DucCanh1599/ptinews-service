package ptinews.entity;

public class CategoryEntity extends BaseEntity<CategoryEntity> {
	
	private String name;
	private String description;
	private String slug;
	private CategoryEntity parentCategory;
	private UserEntity createdBy;
	
	public CategoryEntity() {
	}
	
	public CategoryEntity(String name, String description, String slug,
			CategoryEntity parentCategory, UserEntity createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.slug = slug;
		this.parentCategory = parentCategory;
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public CategoryEntity getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(CategoryEntity parentCategory) {
		this.parentCategory = parentCategory;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}
}
