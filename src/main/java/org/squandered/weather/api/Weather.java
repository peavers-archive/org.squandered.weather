package org.squandered.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Weather {

	@NotEmpty
	private long id;

	@NotNull
	private String windSpeed;

	@NotNull
	private String temperature;

	public Weather() {
		// Jackson deserialization
	}

	public Weather(long id, String windSpeed, String temperature) {
		this.id = id;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public String getWindSpeed() {
		return windSpeed;
	}

	@JsonProperty
	public String getTemperature() {
		return temperature;
	}
}
