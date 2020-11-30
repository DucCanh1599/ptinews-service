package ptinews.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BaseEntity<T> {
	
	private String id;
	private Date createdDate;
	private Date lastModified;
	private boolean status;
	private String[] ids;
	private List<T> listModels = new ArrayList<>();
	
	public BaseEntity() {
	}
	
	public BaseEntity(String id, Date createdDate, String createdBy, Date lastModified,
			boolean status, String[] ids, List<T> listModels) {
		this.id = id;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
		this.status = status;
		this.ids = ids;
		this.listModels = listModels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public List<T> getListModels() {
		return listModels;
	}

	public void setListModels(List<T> listModels) {
		this.listModels = listModels;
	}
}
