import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import org.squandered.weather.api.Weather;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTest {

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

	private final int id = 1;
	private final String latitude = "9.8";
	private final String longitude = "13.1";

	@Test
	public void serializesToJSON() throws Exception {
		final Weather weather = new Weather(id, latitude, longitude, true);

		final String expected = MAPPER.writeValueAsString(
			MAPPER.readValue(fixture("fixtures/weather.json"), Weather.class));

		assertThat(MAPPER.writeValueAsString(weather)).isEqualTo(expected);
	}

	@Test
	public void deserializeFromJSON() throws Exception {
		final Weather weather = new Weather(id, latitude, longitude, true);

		assertThat(MAPPER.readValue(fixture("fixtures/weather.json"), Weather.class)).isEqualTo(weather);
	}
}
