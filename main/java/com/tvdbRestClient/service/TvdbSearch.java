package com.tvdbRestClient.service;

import com.tvdbRestClient.models.response.SearchParamsResponse;
import com.tvdbRestClient.models.response.SeriesResultsResponse;
import com.tvdbRestClient.utils.TvdbCallUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface TvdbSearch {

	@GET("search/series")
	Call<SeriesResultsResponse> series(@Query("name") String name, @Query("imdbId") String imdbId,
			@Query("zap2itId") String zap2itId, @Header(TvdbCallUtils.HEADER_ACCEPT_LANGUAGE) String languages);

	@GET("search/series/params")
	Call<SearchParamsResponse> params();

}
