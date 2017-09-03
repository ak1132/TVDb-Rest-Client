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
import com.tvdbRestClient.models.request.SeriesImageQueryResult;
import com.tvdbRestClient.models.response.ActorResponse;
import com.tvdbRestClient.models.response.EpisodeResponse;
import com.tvdbRestClient.models.response.EpisodesSummaryResponse;
import com.tvdbRestClient.models.response.SeriesImageQueryResultResponse;
import com.tvdbRestClient.models.response.SeriesResponse;
import com.uwetrottmann.thetvdb.entities.EpisodesResponse;
import com.uwetrottmann.thetvdb.entities.SeriesImagesQueryParam;
import com.uwetrottmann.thetvdb.entities.SeriesImagesQueryParamResponse;

import okhttp3.Headers;
import retrofit2.Call;

public class TvSeriesTest extends AbstractTestUtils {

	@Test
	public void test_series() throws IOException {
		Call<SeriesResponse> call = getTvdbTestUtils().getTvdbSeries().series(TestData.SERIES_TVDB_ID,
				TestData.LANGUAGE_EN);
		SeriesResponse seriesResponse = executeCall(call);
		TestData.assertTestSeries(seriesResponse.data);
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
			Call<EpisodeResponse> call = getTvdbTestUtils().getTvdbSeries().episodes(TestData.SERIES_TVDB_ID_STARGATE,
					page, TestData.LANGUAGE_EN);
			EpisodeResponse response = executeCall(call);

			assertEpisodes(response.getData());

			page = response.links.next;
		}
	}

	@Test
	public void test_episodesQuery() throws IOException {
		// search by aired season/episode
		Call<EpisodesResponse> call = getTheTvdb().series().episodesQuery(TestData.SERIES_TVDB_ID, null, 1, // airedSeason
				null, null, null, null, null, null, TestData.LANGUAGE_EN);
		EpisodesResponse episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.data);

		// search by dvd season/episode
		call = getTheTvdb().series().episodesQuery(TestData.SERIES_TVDB_ID, null, null, null, 1, null, null, null, null,
				TestData.LANGUAGE_EN);
		episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.data);

		// search by first aired date
		call = getTheTvdb().series().episodesQuery(TestData.SERIES_TVDB_ID, null, null, null, null, null, null,
				"2009-03-09", null, TestData.LANGUAGE_EN);
		episodesResponse = executeCall(call);
		assertEpisodes(episodesResponse.data);
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
		Call<EpisodesSummaryResponse> call = getTheTvdb().series().episodesSummary(TestData.SERIES_TVDB_ID);
		EpisodesSummaryResponse wrapper = executeCall(call);
		EpisodesSummary episodesSummary = wrapper.data;
		assertThat(episodesSummary.airedSeasons).isNotEmpty();
		assertThat(episodesSummary.airedEpisodes).isPositive();
		assertThat(episodesSummary.dvdSeasons).isNotEmpty();
		assertThat(episodesSummary.dvdEpisodes).isPositive();
	}

	@Test
	public void test_imagesQuery() throws Exception {
		String posterType = "poster";
		Call<SeriesImageQueryResultResponse> call = getTheTvdb().series().imagesQuery(TestData.SERIES_TVDB_ID,
				posterType, null, null, null);
		SeriesImageQueryResultResponse results = executeCall(call);
		for (SeriesImageQueryResult image : results.data) {
			assertThat(image.id).isPositive();
			assertThat(image.keyType).isEqualTo(posterType);
			assertThat(image.fileName).isNotEmpty();
			assertThat(image.resolution).isNotEmpty();
			assertThat(image.ratingsInfo.average).isBetween(0.0, 10.0);
			assertThat(image.ratingsInfo.count).isGreaterThanOrEqualTo(0);
			assertThat(image.thumbnail).isNotEmpty();
		}
	}

	@Test
	public void test_imagesQueryParams() throws IOException {
		Call<SeriesImagesQueryParamResponse> call = getTheTvdb().series().imagesQueryParams(TestData.SERIES_TVDB_ID);
		SeriesImagesQueryParamResponse body = executeCall(call);
		for (SeriesImagesQueryParam queryParam : body.data) {
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
