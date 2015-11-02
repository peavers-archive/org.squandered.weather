package org.squandered.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Weather {

	@NotEmpty
	boolean jersey;
	@NotEmpty
	private long id;
	@NotEmpty
	private String windSpeed;
	@NotEmpty
	private String temperature;

	public Weather() {
		// Jackson deserialization
	}

	public Weather(long id, String windSpeed, String temperature, boolean jersey) {
		this.id = id;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
		this.jersey = jersey;
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

	@JsonProperty
	public boolean getJersey() {
		return jersey;
	}
}
