package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.tvdbRestClient.models.request.LoginData;
import com.tvdbRestClient.models.request.Token;

import retrofit2.Call;

public class TvdbAuthenticationTest extends TestUtils {

	@Test
	public void test_login() throws IOException {

		String apikey = getTvdbTestUtils().getApikey();

		if (StringUtils.isEmpty(apikey)) {
			throw new IllegalArgumentException("Set your TheTVDB API key to test /login.");
		}

		Call<Token> call = getTvdbTestUtils().authenticate().login(new LoginData(apikey));

		Token token = executeCall(call);

		System.out.println("Retrieved token: " + token.getToken() + " (valid for 24 hours)");
	}

	@Test
	public void test_refreshToken() throws IOException {

		String apikey = getTvdbTestUtils().getApikey();

		if (StringUtils.isEmpty(apikey)) {
			throw new IllegalArgumentException("Set your TheTVDB API key to test /login.");
		}

		getTvdbTestUtils().setToken(null);

		Call<Token> call = getTvdbTestUtils().authenticate().login(new LoginData(apikey));

		Token loginToken = executeCall(call);

		getTvdbTestUtils().setToken(loginToken.getToken());

		call = getTvdbTestUtils().authenticate().refreshToken();

		Token refreshedToken = executeCall(call);

		assertThat(refreshedToken.getToken()).isNotEqualTo(loginToken.getToken());

		System.out.println("Old Token: " + loginToken.getToken());

		System.out.println("Refreshed token: " + refreshedToken.getToken() + " (valid for 24 hours)");
	}

}
