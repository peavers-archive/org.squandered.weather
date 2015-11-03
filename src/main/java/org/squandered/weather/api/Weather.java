package org.squandered.weather.api;

import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

public class Weather {

	@NotEmpty
	private boolean jersey;
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

	public boolean isJersey() {
		return jersey;
	}

	public long getId() {
		return id;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public String getTemperature() {
		return temperature;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, windSpeed, temperature, jersey);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Weather)) {
			return false;
		}

		final Weather that = (Weather) obj;

		return Objects.equals(this.id, that.id) &&
			Objects.equals(this.windSpeed, that.windSpeed) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.jersey, that.jersey);
	}


	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("windSpeed", windSpeed)
			.add("temperature", temperature)
			.add("jersey", jersey)
			.toString();
	}


}

