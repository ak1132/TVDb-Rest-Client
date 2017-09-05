package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.tvdbRestClient.models.request.Language;
import com.tvdbRestClient.models.response.LanguageResponse;
import com.tvdbRestClient.models.response.LanguagesResponse;

import retrofit2.Call;

public class TvdbLanguagesTest extends TestUtils {

	@Test
	public void test_allAvailable() throws IOException {
		Call<LanguagesResponse> call = getTvdbTestUtils().getLanguages().allAvailable();
		LanguagesResponse response = executeCall(call);
		List<Language> languages = response.data;
		for (Language language : languages) {
			assertLanguage(language);
		}
	}

	@Test
	public void test_languageDetails() throws Exception {
		Call<LanguageResponse> call = getTvdbTestUtils().getLanguages().languageDetails(TestData.LANGUAGE_EN_ID);
		LanguageResponse response = executeCall(call);
		Language language = response.getData();
		assertLanguage(language);
		assertThat(language.getId()).isEqualTo(TestData.LANGUAGE_EN_ID);
	}

	private void assertLanguage(Language language) {
		assertThat(language.getId()).isPositive();
		// this will break should TheTVDB ever introduce region codes
		assertThat(language.getAbbreviation()).hasSize(2);
		assertThat(language.getName()).isNotEmpty();
		assertThat(language.getEnglishName()).isNotEmpty();
	}

}
