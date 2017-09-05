package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.tvdbRestClient.models.request.FullEpisode;
import com.tvdbRestClient.models.response.FullEpisodeResponse;

public class TvdbEpisodesTest extends TestUtils {
	@Test
	public void test_get() throws Exception {
		FullEpisodeResponse fullEpisodeResponse = executeCall(
				getTvdbTestUtils().getEpisodes().get(TestData.EPISODE_TVDB_ID, TestData.LANGUAGE_EN));
		FullEpisode episode = fullEpisodeResponse.getData();
		TestData.assertBasicEpisode(episode);
		assertThat(episode.getId()).isEqualTo(TestData.EPISODE_TVDB_ID);
	}

	@Test
	public void test_getInvalidLanguage() throws Exception {
		FullEpisodeResponse fullEpisodeResponse = executeCall(
				getTvdbTestUtils().getEpisodes().get(TestData.EPISODE_TVDB_ID, "xx"));
		assertThat(fullEpisodeResponse.getErrors().getInvalidLanguage()).isNotEmpty();
	}

}