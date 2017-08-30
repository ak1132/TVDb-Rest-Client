package com.tvdbRestClient.models.request;

public class TvdbData extends LoginData {

	public static String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		TvdbData.token = token;
	}

}
