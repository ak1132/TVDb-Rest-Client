package com.tvdbRestClient.models.request;

public class Actor {

	private Integer id;
	private Integer seriesId;
	private String name;
	private String role;
	private Integer sortOrder;
	private String image;
	private Integer imageAuthor;
	/** ISO 8601 date-time string, like "2010-09-20 15:05:50". */
	private String imageAdded;
	/** ISO 8601 date-time string, like "2010-09-20 15:05:50". */
	private String lastUpdated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getImageAuthor() {
		return imageAuthor;
	}
	public void setImageAuthor(Integer imageAuthor) {
		this.imageAuthor = imageAuthor;
	}
	public String getImageAdded() {
		return imageAdded;
	}
	public void setImageAdded(String imageAdded) {
		this.imageAdded = imageAdded;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
