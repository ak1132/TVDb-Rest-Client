package com.tvdbRestClient.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Calendar;

import org.junit.Test;

import com.tvdbRestClient.models.request.SeriesUpdate;
import com.tvdbRestClient.models.response.SeriesUpdatesResponse;

public class TvdbUpdatesTest extends TestUtils {

	@Test
	public void test_seriesUpdates() throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -7);
		long timeWeekAgoSeconds = cal.getTimeInMillis() / 1000;

		SeriesUpdatesResponse response = executeCall(
				getTvdbTestUtils().getTvdbSeriesUpdates().get(timeWeekAgoSeconds, null));

		assertThat(response.data).isNotEmpty(); // there have to be some updates over the last 7 days

		for (SeriesUpdate update : response.data) {
			assertThat(update.id).isPositive();
			assertThat(update.lastUpdated).isGreaterThanOrEqualTo(timeWeekAgoSeconds);
		}
	}

}
