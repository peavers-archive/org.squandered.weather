package org.squandered.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Objects;

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

	/**
	 * @param id
	 * @param windSpeed
	 * @param temperature
	 * @param jersey
	 */
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

