package ptinews.entity;

public class CommentEntity extends AbstractEntity<CommentEntity> {
	
	private String content;
	private String userId;
	private String articleId;
	
	public CommentEntity() {
	}

	public CommentEntity(String content, String userId, String articleId) {
		this.content = content;
		this.userId = userId;
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
}
