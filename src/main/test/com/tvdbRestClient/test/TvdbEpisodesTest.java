package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.tvdbRestClient.models.request.Episode;
import com.tvdbRestClient.models.response.EpisodeResponse;

public class TvdbEpisodesTest extends AbstractTestUtils {
	@Test
	public void test_get() throws Exception {
		EpisodeResponse episodeResponse = executeCall(
				getTvdbTestUtils().getEpisodes().get(TestData.EPISODE_TVDB_ID, TestData.LANGUAGE_EN));
		Episode episode = episodeResponse.getData();
		TestData.assertBasicEpisode(episode);
		assertThat(episode.getId()).isEqualTo(TestData.EPISODE_TVDB_ID);
	}

	@Test
	public void test_getInvalidLanguage() throws Exception {
		EpisodeResponse episodeResponse = executeCall(
				getTvdbTestUtils().getEpisodes().get(TestData.EPISODE_TVDB_ID, "xx"));
		assertThat(episodeResponse.errors.invalidLanguage).isNotEmpty();
	}

}