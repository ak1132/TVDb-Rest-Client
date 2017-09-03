package com.tvdbRestClient.service;

import com.tvdbRestClient.models.response.EpisodeResponse;
import com.tvdbRestClient.utils.TvdbCallUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface TvdbEpisodes {

	@GET("episodes/{id}")
	Call<EpisodeResponse> get(@Path("id") int id, @Header(TvdbCallUtils.HEADER_ACCEPT_LANGUAGE) String language);

}
