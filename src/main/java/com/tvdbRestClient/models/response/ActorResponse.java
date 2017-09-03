package com.tvdbRestClient.models.response;

import java.util.List;

import com.tvdbRestClient.models.request.Actor;

public class ActorResponse extends ErrorResponse {

	private List<Actor> data;

	public List<Actor> getActorData() {
		return data;
	}

	public void setActorData(List<Actor> data) {
		this.data = data;
	}
}