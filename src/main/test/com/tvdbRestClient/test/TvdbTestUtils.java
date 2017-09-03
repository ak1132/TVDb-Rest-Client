package com.tvdbRestClient.test;

import com.tvdbRestClient.utils.TvdbUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class TvdbTestUtils {

	private static final boolean DEBUG = true;

	private static TvdbUtils tvdbUtils;

	protected void getTestOkHttpClient() {
		OkHttpClient.Builder builder = getTvdbUtils().getOkHttpClient().newBuilder();
		if (DEBUG) {
			// add logging
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
				@Override
				public void log(String s) {
					// standard output is easier to read
					System.out.println(s);
				}
			});
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			builder.addInterceptor(logging);
		}
	}

	public TvdbUtils getTvdbUtils() {
		if (tvdbUtils == null) {
			tvdbUtils = new TvdbUtils();
			return tvdbUtils;
		}
		return tvdbUtils;
	}

}
