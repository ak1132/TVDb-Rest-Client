package com.tvdbRestClient.models.request;

import java.util.List;

public class EpisodesSummary {

	private List<Integer> airedSeasons;
	private Integer airedEpisodes;
	private List<Integer> dvdSeasons;
	private Integer dvdEpisodes;

	public List<Integer> getAiredSeasons() {
		return airedSeasons;
	}

	public void setAiredSeasons(List<Integer> airedSeasons) {
		this.airedSeasons = airedSeasons;
	}

	public Integer getAiredEpisodes() {
		return airedEpisodes;
	}

	public void setAiredEpisodes(Integer airedEpisodes) {
		this.airedEpisodes = airedEpisodes;
	}

	public List<Integer> getDvdSeasons() {
		return dvdSeasons;
	}

	public void setDvdSeasons(List<Integer> dvdSeasons) {
		this.dvdSeasons = dvdSeasons;
	}

	public Integer getDvdEpisodes() {
		return dvdEpisodes;
	}

	public void setDvdEpisodes(Integer dvdEpisodes) {
		this.dvdEpisodes = dvdEpisodes;
	}

}