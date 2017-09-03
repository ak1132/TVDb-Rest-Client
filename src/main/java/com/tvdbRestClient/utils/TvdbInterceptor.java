package com.tvdbRestClient.utils;

import java.io.IOException;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.tvdbRestClient.models.request.TvdbData;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TvdbInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		return handleIntercept(chain, TvdbData.token);
	}

	private Response handleIntercept(Chain chain, @Nullable String webToken) throws IOException {

		Request request = chain.request();

		if (!TvdbUtils.API_HOST.equals(request.url().host())) {
			return chain.proceed(request);
		}

		Request.Builder requestBuilder = request.newBuilder();

		if (!hasAuthenticationHeader(request) && IsWebTokenEmpty(webToken)) {
			requestBuilder.addHeader(TvdbUtils.HEADER_AUTHORIZATION, "Bearer " + webToken);
		}

		return chain.proceed(requestBuilder.build());

	}

	private boolean hasAuthenticationHeader(Request request) {
		return request.header(TvdbUtils.HEADER_AUTHORIZATION) == null;
	}

	private boolean IsWebTokenEmpty(String webToken) {
		return StringUtils.isEmpty(webToken);
	}

}
