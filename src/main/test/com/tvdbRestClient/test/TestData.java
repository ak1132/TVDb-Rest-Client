package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.tvdbRestClient.models.request.FullEpisode;
import com.tvdbRestClient.models.request.Series;

public class TestData {

	public static final int SERIES_TVDB_ID = 83462;
	public static final int EPISODE_TVDB_ID = 398671;
	public static final String SERIES_NAME = "Castle (2009)";
	public static final String LANGUAGE_EN = "en";
	public static final int LANGUAGE_EN_ID = 7;

	// add show that has double episode DVD numbers
	public static final int SERIES_TVDB_ID_STARGATE = 72449;

	public static void assertTestSeries(Series series) {
		assertThat(series.getId()).isEqualTo(SERIES_TVDB_ID);
		assertThat(series.getSeriesName()).isEqualTo(SERIES_NAME);
		assertThat(series.getImdbId()).isEqualTo("tt1219024");
		assertThat(series.getZap2itId()).isEqualTo("EP01085588");
		assertThat(series.getAdded()).isEqualTo("2008-10-17 15:05:50");
	}

	public static void assertBasicEpisode(FullEpisode episode) {

		assertThat(episode.getId()).isPositive();

		assertThat(episode.getAiredEpisodeNumber()).isGreaterThanOrEqualTo(0);

		if (episode.getAbsoluteNumber() != null) {
			assertThat(episode.getAbsoluteNumber()).isGreaterThanOrEqualTo(0);
		}
		if (episode.getDvdEpisodeNumber() != null) {
			assertThat(episode.getDvdEpisodeNumber()).isGreaterThanOrEqualTo(0);
		}
		if (episode.getDvdSeason() != null) {
			assertThat(episode.getDvdSeason()).isGreaterThanOrEqualTo(0);
		}

		assertThat(episode.getAiredSeason()).isGreaterThanOrEqualTo(0);

		if (episode.getAiredSeasonID() != null) {
			assertThat(episode.getAiredSeasonID()).isPositive();
		}
		if (episode.getEpisodeName() != null) {
			assertThat(episode.getLanguage().getEpisodeName()).isEqualTo(LANGUAGE_EN);
		}
		if (episode.getOverview() != null) {
			assertThat(episode.getLanguage().getOverview()).isEqualTo(LANGUAGE_EN);
		}
	}
}
