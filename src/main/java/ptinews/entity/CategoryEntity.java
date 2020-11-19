package ptinews.entity;

public class CategoryEntity extends AbstractEntity<CategoryEntity> {
	
	private String name;
	private String description;
	private boolean status;
	private String slug;
	private String thumnail;
	
	public CategoryEntity() {
	}
	
	public CategoryEntity(String name, String description, boolean status, String slug, String thumnail) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.slug = slug;
		this.thumnail = thumnail;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getThumnail() {
		return thumnail;
	}

	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
}
