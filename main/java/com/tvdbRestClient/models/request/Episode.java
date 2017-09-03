package com.tvdbRestClient.models.request;

public class Episode {

	public Integer id;
	public Integer absoluteNumber;
	public Integer airedEpisodeNumber;
	public Integer airedSeason;
	public Integer airedSeasonID;
	public Double dvdEpisodeNumber;
	public Integer dvdSeason;
	public String episodeName;
	/** ISO 8601 date string, like "2010-09-20". */
	public String firstAired;
	/** ISO 639-1 language codes, like "en". */
	public Translations language;
	/** Time in seconds, like 1430845514. */
	public Long lastUpdated;
	public String overview;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAbsoluteNumber() {
		return absoluteNumber;
	}

	public void setAbsoluteNumber(Integer absoluteNumber) {
		this.absoluteNumber = absoluteNumber;
	}

	public Integer getAiredEpisodeNumber() {
		return airedEpisodeNumber;
	}

	public void setAiredEpisodeNumber(Integer airedEpisodeNumber) {
		this.airedEpisodeNumber = airedEpisodeNumber;
	}

	public Integer getAiredSeason() {
		return airedSeason;
	}

	public void setAiredSeason(Integer airedSeason) {
		this.airedSeason = airedSeason;
	}

	public Integer getAiredSeasonID() {
		return airedSeasonID;
	}

	public void setAiredSeasonID(Integer airedSeasonID) {
		this.airedSeasonID = airedSeasonID;
	}

	public Double getDvdEpisodeNumber() {
		return dvdEpisodeNumber;
	}

	public void setDvdEpisodeNumber(Double dvdEpisodeNumber) {
		this.dvdEpisodeNumber = dvdEpisodeNumber;
	}

	public Integer getDvdSeason() {
		return dvdSeason;
	}

	public void setDvdSeason(Integer dvdSeason) {
		this.dvdSeason = dvdSeason;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getFirstAired() {
		return firstAired;
	}

	public void setFirstAired(String firstAired) {
		this.firstAired = firstAired;
	}

	public Translations getLanguage() {
		return language;
	}

	public void setLanguage(Translations language) {
		this.language = language;
	}

	public Long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

}