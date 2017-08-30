package com.tvdbRestClient.models.request;

import java.util.List;

public class FullEpisode extends Episode {
	public Integer airsAfterSeason;
	public Integer airsBeforeEpisode;
	public Integer airsBeforeSeason;
	public List<String> directors;
	public String dvdChapter;
	public String dvdDiscid;
	/** Episode image path suffix, like "episodes/83462/398671.jpg". */
	public String filename;
	public List<String> guestStars;
	public String imdbId;
	/** TheTVDB user id. */
	public Integer lastUpdatedBy;
	public String productionCode;
	/** TheTVDB series id. */
	public Integer seriesId;
	public String showUrl;
	/** Value from 0.0 to 10.0. */
	public Double siteRating;
	public Integer siteRatingCount;
	public String thumbAdded;
	/** TheTVDB user id. */
	public Integer thumbAuthor;
	public String thumbWidth;
	public String thumbHeight;
	public List<String> writers;

	public Integer getAirsAfterSeason() {
		return airsAfterSeason;
	}

	public void setAirsAfterSeason(Integer airsAfterSeason) {
		this.airsAfterSeason = airsAfterSeason;
	}

	public Integer getAirsBeforeEpisode() {
		return airsBeforeEpisode;
	}

	public void setAirsBeforeEpisode(Integer airsBeforeEpisode) {
		this.airsBeforeEpisode = airsBeforeEpisode;
	}

	public Integer getAirsBeforeSeason() {
		return airsBeforeSeason;
	}

	public void setAirsBeforeSeason(Integer airsBeforeSeason) {
		this.airsBeforeSeason = airsBeforeSeason;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public String getDvdChapter() {
		return dvdChapter;
	}

	public void setDvdChapter(String dvdChapter) {
		this.dvdChapter = dvdChapter;
	}

	public String getDvdDiscid() {
		return dvdDiscid;
	}

	public void setDvdDiscid(String dvdDiscid) {
		this.dvdDiscid = dvdDiscid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<String> getGuestStars() {
		return guestStars;
	}

	public void setGuestStars(List<String> guestStars) {
		this.guestStars = guestStars;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getProductionCode() {
		return productionCode;
	}

	public void setProductionCode(String productionCode) {
		this.productionCode = productionCode;
	}

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
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

	public String getThumbAdded() {
		return thumbAdded;
	}

	public void setThumbAdded(String thumbAdded) {
		this.thumbAdded = thumbAdded;
	}

	public Integer getThumbAuthor() {
		return thumbAuthor;
	}

	public void setThumbAuthor(Integer thumbAuthor) {
		this.thumbAuthor = thumbAuthor;
	}

	public String getThumbWidth() {
		return thumbWidth;
	}

	public void setThumbWidth(String thumbWidth) {
		this.thumbWidth = thumbWidth;
	}

	public String getThumbHeight() {
		return thumbHeight;
	}

	public void setThumbHeight(String thumbHeight) {
		this.thumbHeight = thumbHeight;
	}

	public List<String> getWriters() {
		return writers;
	}

	public void setWriters(List<String> writers) {
		this.writers = writers;
	}
}
