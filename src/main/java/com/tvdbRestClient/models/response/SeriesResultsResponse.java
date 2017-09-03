package com.tvdbRestClient.models.response;

import java.util.List;

import com.tvdbRestClient.models.request.Series;

public class SeriesResultsResponse {

	private List<Series> data;

	public List<Series> getData() {
		return data;
	}

	public void setData(List<Series> data) {
		this.data = data;
	}

}
