package com.tvdbRestClient.models.request;

public class SeriesImageQueryResult {

	private int id;
	private String keyType;
	private String subKey;
	private String fileName;
	private String resolution;
	private String thumbnail;
	private RatingsInfo ratingsInfo;

	public RatingsInfo getRatingsInfo() {
		return ratingsInfo;
	}

	public void setRatingsInfo(RatingsInfo ratingsInfo) {
		this.ratingsInfo = ratingsInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getSubKey() {
		return subKey;
	}

	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}