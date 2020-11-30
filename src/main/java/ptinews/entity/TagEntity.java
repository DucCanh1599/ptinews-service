package ptinews.entity;

public class TagEntity extends BaseEntity<TagEntity> {

	private String name;

	public TagEntity() {
	}

	public TagEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
