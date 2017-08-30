package com.tvdbRestClient.service;

import com.tvdbRestClient.models.request.LoginData;
import com.tvdbRestClient.models.request.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TvdbAuthentication {
	
	@POST("login")
	Call<Token> login(@Body LoginData loginData);
	
	@GET("refresh_token")
	Call<Token> refreshToken();

}
