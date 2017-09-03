package com.tvdbRestClient.utils;

import java.io.IOException;

import com.tvdbRestClient.models.request.LoginData;
import com.tvdbRestClient.models.request.Token;
import com.tvdbRestClient.models.request.TvdbData;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

public class TvdbAuthenticator implements Authenticator {

	private TvdbCallUtils tvdbCallUtils;

	public TvdbAuthenticator(TvdbCallUtils tvdbCallUtils) {
		this.tvdbCallUtils = tvdbCallUtils;
	}

	@Override
	public Request authenticate(Route route, Response response) throws IOException {

		Request authResponse = response.request();

		String requestUrl = authResponse.url().encodedPath();

		String LOGIN_PATH = "/" + LoginData.LOGIN_PATH;

		if (LOGIN_PATH.equals(requestUrl)) {
			return null;
		}

		if (responseCount(response) > 2) {
			return null;
		}

		Call<Token> loginCall = tvdbCallUtils.authenticate().login(new LoginData(tvdbCallUtils.getApikey()));

		retrofit2.Response<Token> loginResponse = loginCall.execute();

		if (!loginResponse.isSuccessful()) {
			return null;
		}

		TvdbData.token = loginResponse.body().getToken();

		// retry request
		return authResponse.newBuilder().header(TvdbCallUtils.HEADER_AUTHORIZATION, "Bearer" + " " + TvdbData.token)
				.build();

	}

	private int responseCount(Response response) {
		int result = 0;
		while ((response = response.priorResponse()) != null) {
			++result;
		}
		return result;
	}

}
