package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.tvdbRestClient.models.request.LoginData;
import com.tvdbRestClient.models.request.Token;
import com.tvdbRestClient.utils.TvdbCallUtils;

import retrofit2.Call;

public class TvdbAuthenticationTest extends TvdbTestUtils {

	@Test
	public void test_login() throws IOException {

		if (TvdbCallUtils.apikey.length() == 0) {
			throw new IllegalArgumentException("Set your TheTVDB API key to test /login.");
		}

		Call<Token> call = TvdbCallUtils.authenticate().login(new LoginData(TvdbCallUtils.apikey));

		Token token = executeCall(call);

		System.out.println("Retrieved token: " + token.getToken() + " (valid for 24 hours)");
	}

	@Test
	public void test_refreshToken() throws IOException {

		if (TvdbCallUtils.apikey.length() == 0) {
			throw new IllegalArgumentException("Set your TheTVDB API key to test /login.");
		}

		TvdbCallUtils.token = null;

		Call<Token> call = TvdbCallUtils.authenticate().login(new LoginData(TvdbCallUtils.apikey));

		Token token = executeCall(call);

		TvdbCallUtils.token = token.getToken();

		call = TvdbCallUtils.authenticate().refreshToken();

		Token refreshedToken = executeCall(call);

		assertThat(refreshedToken.getToken()).isNotEqualTo(token.getToken());

		System.out.println("Old Token: " + token.getToken());

		System.out.println("Refreshed token: " + refreshedToken.getToken() + " (valid for 24 hours)");
	}

}
