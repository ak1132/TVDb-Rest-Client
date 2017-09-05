package com.tvdbRestClient.models.response;

import java.util.List;

import com.tvdbRestClient.models.request.FullEpisode;
import com.tvdbRestClient.models.request.Links;

public class EpisodesResponse extends ErrorResponse {

	private Links links;

	private List<FullEpisode> data;

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public List<FullEpisode> getData() {
		return data;
	}

	public void setData(List<FullEpisode> data) {
		this.data = data;
	}

}