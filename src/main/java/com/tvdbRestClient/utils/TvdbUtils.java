package com.tvdbRestClient.utils;

import com.tvdbRestClient.service.TvdbAuthentication;
import com.tvdbRestClient.service.TvdbEpisodes;
import com.tvdbRestClient.service.TvdbLanguages;
import com.tvdbRestClient.service.TvdbSearch;
import com.tvdbRestClient.service.TvdbSeries;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvdbUtils {

	public static final String API_HOST = "api.thetvdb.com";
	public static final String URL = " https://" + API_HOST + "/";
	public static final String HEADER_ACCEPT = "Accept";
	public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
	public static final String HEADER_AUTHORIZATION = "Authorization";

	public static final String apikey = "1992394273E010A4";

	public String token = null;

	private OkHttpClient okHttpClient;

	private Retrofit retrofit;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Retrofit getTvdbRetrofitClient() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder().baseUrl(TvdbUtils.URL).addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}

	public OkHttpClient getOkHttpClient() {
		if (okHttpClient == null) {
			OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
					.addNetworkInterceptor(new TvdbInterceptor()).authenticator(new TvdbAuthenticator(this));
			okHttpClient = okHttpClientBuilder.build();
		}
		return okHttpClient;
	}

	public TvdbAuthentication authenticate() {
		return getTvdbRetrofitClient().create(TvdbAuthentication.class);
	}

	public TvdbEpisodes getEpisodes() {
		return getTvdbRetrofitClient().create(TvdbEpisodes.class);
	}

	public TvdbLanguages getLanguages() {
		return getTvdbRetrofitClient().create(TvdbLanguages.class);
	}

	public TvdbSearch searchTvdb() {
		return getTvdbRetrofitClient().create(TvdbSearch.class);
	}

	public TvdbSeries getTvdbSeries() {
		return getTvdbRetrofitClient().create(TvdbSeries.class);
	}

}
