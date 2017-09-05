package com.tvdbRestClient.models.response;

import java.util.List;

import com.tvdbRestClient.models.request.SeriesImageQueryParam;

public class SeriesImageQueryParamResponse {

	private List<SeriesImageQueryParam> data;

	public List<SeriesImageQueryParam> getData() {
		return data;
	}

	public void setData(List<SeriesImageQueryParam> data) {
		this.data = data;
	}

}
