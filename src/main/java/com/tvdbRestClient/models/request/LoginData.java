package com.tvdbRestClient.models.request;

import java.util.ResourceBundle;

public class LoginData {

	public static final String LOGIN_PATH = "login";

	private String apikey;
	private String username;
	private String userpass;

	private ResourceBundle rb = ResourceBundle.getBundle(LoginData.class.getName());

	public String getApikey() {
		apikey = rb.getString("apikey");
		return apikey;
	}

	public String getUsername() {
		username = rb.getString("username");
		return username;
	}

	public String getUserpass() {
		userpass = rb.getString("userpass");
		return userpass;
	}

}
