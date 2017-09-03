package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.fail;

import java.io.IOException;

import org.junit.BeforeClass;

import com.tvdbRestClient.utils.TvdbCallUtils;

import retrofit2.Call;
import retrofit2.Response;

public class TvdbTestUtils {

	private static final String apikey = "1992394273E010A4";

	protected <T> T executeCall(Call<T> call) throws IOException {
		Response<T> response = call.execute();
		if (response.isSuccessful()) {
			T body = response.body();
			if (body == null) {
				fail("body == null");
			} else {
				return body;
			}
		} else {
			handleFailedResponse(response);
		}
		return null;
	}

	@BeforeClass
	public static void setUpOnce() {
		new TvdbCallUtils(apikey);
	}

	private static void handleFailedResponse(Response response) {
		if (response.code() == 401) {
			fail(String.format("Authorization required: %d %s", response.code(), response.message()));
		} else {
			fail(String.format("Request failed: %d %s", response.code(), response.message()));
		}
	}

}
