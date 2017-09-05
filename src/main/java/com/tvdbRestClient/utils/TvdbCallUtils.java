package com.tvdbRestClient.utils;

import com.tvdbRestClient.service.TvdbAuthentication;
import com.tvdbRestClient.service.TvdbEpisodes;
import com.tvdbRestClient.service.TvdbLanguages;
import com.tvdbRestClient.service.TvdbSearch;
import com.tvdbRestClient.service.TvdbSeries;
import com.tvdbRestClient.service.TvdbUpdates;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvdbCallUtils {

	public static final String API_HOST = "api.thetvdb.com";
	public static final String URL = " https://" + API_HOST + "/";
	public static final String HEADER_ACCEPT = "Accept";
	public static final String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
	public static final String HEADER_AUTHORIZATION = "Authorization";

	public String apikey;

	public String token;

	protected OkHttpClient okHttpClient;

	private Retrofit retrofit;

	public TvdbCallUtils(String apikey) {
		this.apikey = apikey;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Retrofit getTvdbRetrofitClient() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder().baseUrl(TvdbCallUtils.URL)
					.addConverterFactory(GsonConverterFactory.create()).client(getOkHttpClient()).build();
		}
		return retrofit;
	}

	protected OkHttpClient getOkHttpClient() {

		if (okHttpClient == null) {
			OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
			setOkHttpConfig(okHttpClientBuilder, false);
			okHttpClient = okHttpClientBuilder.build();
		}
		return okHttpClient;
	}

	protected OkHttpClient.Builder setOkHttpConfig(OkHttpClient.Builder okHttpClientBuilder, boolean DEBUG) {
		okHttpClientBuilder.addNetworkInterceptor(new TvdbInterceptor()).authenticator(new TvdbAuthenticator(this));
		if (DEBUG) {
			// add logging
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
				@Override
				public void log(String s) {
					System.out.println(s);
				}
			});
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			okHttpClientBuilder.addInterceptor(logging);
		}
		return okHttpClientBuilder;
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

	public TvdbUpdates getTvdbSeriesUpdates() {
		return getTvdbRetrofitClient().create(TvdbUpdates.class);
	}

}
