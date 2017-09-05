package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.fail;

import java.io.IOException;

import com.tvdbRestClient.utils.TvdbCallUtils;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

public class TestUtils {

	private static final String apikey = "1992394273E010A4";

	private TvdbTestUtils tvdbTestUtils = null;

	static class TvdbTestUtils extends TvdbCallUtils {

		public TvdbTestUtils(String apikey) {
			super(apikey);
		}

		@Override
		protected OkHttpClient getOkHttpClient() {

			if (okHttpClient == null) {
				OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
				setOkHttpConfig(okHttpClientBuilder, true);
				okHttpClient = okHttpClientBuilder.build();
			}
			return okHttpClient;
		}
	}

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

	public TvdbTestUtils getTvdbTestUtils() {

		if (tvdbTestUtils == null) {
			return new TvdbTestUtils(apikey);
		}
		return tvdbTestUtils;
	}

	private static void handleFailedResponse(Response response) {
		if (response.code() == 401) {
			fail(String.format("Authorization required: %d %s", response.code(), response.message()));
		} else {
			fail(String.format("Request failed: %d %s", response.code(), response.message()));
		}
	}

}
