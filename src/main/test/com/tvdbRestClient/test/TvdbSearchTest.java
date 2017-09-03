package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.tvdbRestClient.models.request.Series;
import com.tvdbRestClient.models.response.SearchParamsResponse;
import com.tvdbRestClient.models.response.SeriesResultsResponse;

import retrofit2.Call;

public class TvdbSearchTest extends AbstractTestUtils {

	@Test
	public void test_series() throws IOException {
		Call<SeriesResultsResponse> call = getTvdbTestUtils().searchTvdb().series(TestData.SERIES_NAME, null, null,
				TestData.LANGUAGE_EN);
		SeriesResultsResponse results = executeCall(call);
		for (Series series : results.getData()) {
			assertThat(series.getId()).isPositive();
			assertThat(series.getSeriesName()).isNotEmpty();
		}
	}

	@Test
	public void test_params() throws Exception {
		Call<SearchParamsResponse> call = getTvdbTestUtils().searchTvdb().params();
		SearchParamsResponse result = executeCall(call);
		for (String param : result.data.params) {
			assertThat(param).isNotEmpty();
		}
	}
}
