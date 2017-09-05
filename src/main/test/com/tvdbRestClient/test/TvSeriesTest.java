package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import javax.annotation.Nullable;

import org.junit.Test;

import com.tvdbRestClient.models.request.Actor;
import com.tvdbRestClient.models.request.EpisodesSummary;
import com.tvdbRestClient.models.request.FullEpisode;
import com.tvdbRestClient.models.request.SeriesImageQueryParam;
import com.tvdbRestClient.models.request.SeriesImageQueryResult;
import com.tvdbRestClient.models.response.ActorResponse;
import com.tvdbRestClient.models.response.EpisodesResponse;
import com.tvdbRestClient.models.response.EpisodesSummaryResponse;
import com.tvdbRestClient.models.response.SeriesImageQueryParamResponse;
import com.tvdbRestClient.models.response.SeriesImageQueryResultResponse;
import com.tvdbRestClient.models.response.SeriesResponse;

import okhttp3.Headers;
import retrofit2.Call;

public class TvSeriesTest extends TestUtils {

	@Test
	public void test_series() throws IOException {
		Call<SeriesResponse> call = getTvdbTestUtils().getTvdbSeries().series(TestData.SERIES_TVDB_ID,
				TestData.LANGUAGE_EN);

		SeriesResponse seriesResponse = executeCall(call);

		TestData.assertTestSeries(seriesResponse.getData());
	}

	@Test
	public void test_seriesHeader() throws IOException {

		Call<Void> call = getTvdbTestUtils().getTvdbSeries().seriesHeader(TestData.SERIES_TVDB_ID,
				TestData.LANGUAGE_EN);

		Headers headers = call.execute().headers();

		assertThat(headers.get("Last-Modified")).isNotEmpty();
	}

	@Test
	public void test_actors() throws IOException {

		ActorResponse response = executeCall(getTvdbTestUtils().getTvdbSeries().actors(TestData.SERIES_TVDB_ID));

		assertThat(response.getActorData()).isNotEmpty();

		for (Actor actor : response.getActorData()) {
			assertThat(actor.getId()).isPositive();
			assertThat(actor.getSeriesId()).isEqualTo(TestData.SERIES_TVDB_ID);
			assertThat(actor.getName()).isNotEmpty();
		}
	}

	@Test
	public void test_episodes() throws IOException {

		Integer page = 0;

		while (page != null) {

			Call<EpisodesResponse> call = getTvdbTestUtils().getTvdbSeries().episodes(TestData.SERIES_TVDB_ID_STARGATE,
					page, TestData.LANGUAGE_EN);

			EpisodesResponse response = executeCall(call);

			assertEpisodes(response.getData());

			page = response.getLinks().getNext();
		}
	}

	@Test
	public void test_episodesQuery() throws IOException {
		// search by aired season/episode
		Call<EpisodesResponse> call = getTvdbTestUtils().getTvdbSeries().episodesQuery(TestData.SERIES_TVDB_ID, null, 1, // airedSeason
				null, null, null, null, null, null, TestData.LANGUAGE_EN);
		EpisodesResponse episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.getData());

		// search by dvd season/episode
		call = getTvdbTestUtils().getTvdbSeries().episodesQuery(TestData.SERIES_TVDB_ID, null, null, null, 1, null,
				null, null, null, TestData.LANGUAGE_EN);
		episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.getData());

		// search by first aired date
		call = getTvdbTestUtils().getTvdbSeries().episodesQuery(TestData.SERIES_TVDB_ID, null, null, null, null, null,
				null, "2009-03-09", null, TestData.LANGUAGE_EN);
		episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.getData());
	}

	private static void assertEpisodes(@Nullable List<FullEpisode> fullEpisode) {
		if (fullEpisode == null) {
			fail("episodes == null");
		}
		for (FullEpisode episode : fullEpisode) {
			TestData.assertBasicEpisode(episode);
		}
	}

	@Test
	public void test_episodesSummary() throws IOException {

		Call<EpisodesSummaryResponse> call = getTvdbTestUtils().getTvdbSeries()
				.episodesSummary(TestData.SERIES_TVDB_ID);

		EpisodesSummaryResponse wrapper = executeCall(call);

		EpisodesSummary episodesSummary = wrapper.getData();

		assertThat(episodesSummary.getAiredSeasons()).isNotEmpty();
		assertThat(episodesSummary.getAiredEpisodes()).isPositive();
		assertThat(episodesSummary.getDvdSeasons()).isNotEmpty();
		assertThat(episodesSummary.getDvdEpisodes()).isPositive();
	}

	@Test
	public void test_imagesQuery() throws Exception {

		String posterType = "poster";

		Call<SeriesImageQueryResultResponse> call = getTvdbTestUtils().getTvdbSeries()
				.imagesQuery(TestData.SERIES_TVDB_ID, posterType, null, null, null);

		SeriesImageQueryResultResponse results = executeCall(call);

		for (SeriesImageQueryResult image : results.data) {
			assertThat(image.getId()).isPositive();
			assertThat(image.getKeyType()).isEqualTo(posterType);
			assertThat(image.getFileName()).isNotEmpty();
			assertThat(image.getResolution()).isNotEmpty();
			assertThat(image.getRatingsInfo().getAverage()).isBetween(0.0, 10.0);
			assertThat(image.getRatingsInfo().getCount()).isGreaterThanOrEqualTo(0);
			assertThat(image.getThumbnail()).isNotEmpty();
		}
	}

	@Test
	public void test_imagesQueryParams() throws IOException {

		Call<SeriesImageQueryParamResponse> call = getTvdbTestUtils().getTvdbSeries()
				.imagesQueryParams(TestData.SERIES_TVDB_ID);

		SeriesImageQueryParamResponse body = executeCall(call);

		for (SeriesImageQueryParam queryParam : body.getData()) {

			assertThat(queryParam.keyType).isNotEmpty();

			for (String resolution : queryParam.resolution) {
				assertThat(resolution).isNotEmpty();
			}

			for (String subKey : queryParam.subKey) {
				assertThat(subKey).isNotEmpty();
			}
		}
	}
}
