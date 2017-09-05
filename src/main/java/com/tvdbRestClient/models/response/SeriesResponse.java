package com.tvdbRestClient.models.response;

import com.tvdbRestClient.models.request.Series;

public class SeriesResponse extends ErrorResponse {

	private Series data;

	public Series getData() {
		return data;
	}

	public void setData(Series data) {
		this.data = data;
	}

}
