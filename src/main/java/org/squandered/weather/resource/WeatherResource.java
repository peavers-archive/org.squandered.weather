package org.squandered.weather.resource;

import com.codahale.metrics.annotation.Timed;
import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.google.common.base.Optional;
import org.squandered.weather.api.Weather;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherResource {

	private final String defaultLatitude;
	private final String defaultLongitude;
	private final AtomicLong counter;

	public WeatherResource(String defaultLatitude, String defaultLongitude) {
		this.defaultLatitude = defaultLatitude;
		this.defaultLongitude = defaultLongitude;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	public Weather weather(@QueryParam("latitude") Optional<String> latitude, @QueryParam("longitude") Optional<String> longitude) {

		final String latitudeValue = latitude.or(defaultLatitude);
		final String longitudeValue = longitude.or(defaultLongitude);

		ForecastIO fio = new ForecastIO("1a2538107441d1a2503e1b89e20d7c71");
		fio.setUnits(ForecastIO.UNITS_SI);
		fio.setLang(ForecastIO.LANG_ENGLISH);
		fio.setExcludeURL("hourly,minutely");
		fio.getForecast(latitudeValue, longitudeValue);

		FIOCurrently currently = new FIOCurrently(fio);
		String wind = currently.get().windSpeed().toString();
		String temp = currently.get().temperature().toString();

		final boolean jersey = currently.get().temperature() < 12;

		return new Weather(counter.incrementAndGet(), wind, temp, jersey);
	}
}
