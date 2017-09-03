package com.tvdbRestClient.models.request;

import java.util.List;

import com.google.common.collect.Lists;

public class Series {

	/**
	 * An unsigned integer assigned by our site to the series. It does not change
	 * and will always represent the same series. Cannot be null.
	 */
	private Integer id;
	private String seriesName;
	private List<String> aliases = Lists.newArrayList();
	/** Image path suffix, like "graphical/83462-g20.jpg". */
	private String banner;
	/**
	 * A string containing either "Ended" or "Continuing". Can be null.
	 */
	private String status;
	/** ISO 8601 date string, like "2010-09-20". */
	private String firstAired;
	private String network;
	private String networkId;
	/** In minutes. */
	private String runtime;
	private List<String> genre = Lists.newArrayList();
	private String overview;
	/** Time in seconds, like 1430845514. */
	private Long lastUpdated;
	/** An English day string, like "Monday". */
	private String airsDayOfWeek;
	/** In most cases a AM/PM time string, like "9:00 PM". Good luck with this. */
	private String airsTime;
	/** US rating, like "TV-MA". */
	private String rating;
	private String imdbId;
	private String zap2itId;
	/** ISO 8601 date-time string, like "2010-09-20 15:05:50". */
	private String added;
	/** TheTVDB user id. */
	private Integer addedBy;
	/** Value from 0.0 to 10.0. */
	private Double siteRating;
	private Integer siteRatingCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public Long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getAirsDayOfWeek() {
		return airsDayOfWeek;
	}

	public void setAirsDayOfWeek(String airsDayOfWeek) {
		this.airsDayOfWeek = airsDayOfWeek;
	}

	public String getAirsTime() {
		return airsTime;
	}

	public void setAirsTime(String airsTime) {
		this.airsTime = airsTime;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getZap2itId() {
		return zap2itId;
	}

	public void setZap2itId(String zap2itId) {
		this.zap2itId = zap2itId;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public Integer getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Integer addedBy) {
		this.addedBy = addedBy;
	}

	public Double getSiteRating() {
		return siteRating;
	}

	public void setSiteRating(Double siteRating) {
		this.siteRating = siteRating;
	}

	public Integer getSiteRatingCount() {
		return siteRatingCount;
	}

	public void setSiteRatingCount(Integer siteRatingCount) {
		this.siteRatingCount = siteRatingCount;
	}

}