package com.tvdbRestClient.models.request;

public class LoginData {

	public static final String LOGIN_PATH = "login";

	private String apikey;

	public LoginData(String apikey) {
		this.apikey = apikey;
	}

}
