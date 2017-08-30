package com.tvdbRestClient.service;

import com.tvdbRestClient.models.response.LanguageResponse;
import com.tvdbRestClient.models.response.LanguagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TvdbLanguages {

	@GET("languages")
	Call<LanguagesResponse> allAvailable();

	/**
	 * Information about a particular language, given the language ID.
	 */
	@GET("languages/{id}")
	Call<LanguageResponse> languageDetails(@Path("id") int id);

}
