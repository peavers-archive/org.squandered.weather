package org.squandered.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class WeatherConfiguration extends Configuration {

	@NotEmpty
	private String defaultLatitude = "-41.276058"; //Wellington

	@NotEmpty
	private String defaultLongitude = "174.7788987"; //Wellington

	@JsonProperty
	public String getDefaultLatitude() {
		return defaultLatitude;
	}

	@JsonProperty
	public void setDefaultLatitude(String defaultLatitude) {
		this.defaultLatitude = defaultLatitude;
	}

	@JsonProperty
	public String getDefaultLongitude() {
		return defaultLongitude;
	}

	@JsonProperty
	public void setDefaultLongitude(String defaultLongitude) {
		this.defaultLongitude = defaultLongitude;
	}
}
