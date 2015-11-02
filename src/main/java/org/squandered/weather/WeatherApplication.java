package org.squandered.weather;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.squandered.weather.resource.WeatherResource;

public class WeatherApplication extends Application<WeatherConfiguration> {

	public static void main(String[] args) throws Exception {
		new WeatherApplication().run(args);
	}

	@Override
	public String getName() {
		return "weather";
	}

	@Override
	public void initialize(Bootstrap<WeatherConfiguration> bootstrap) {

	}

	@Override
	public void run(WeatherConfiguration configuration, Environment environment) throws Exception {

		final WeatherResource resource = new WeatherResource(
			configuration.getDefaultLatitude(),
			configuration.getDefaultLongitude()
		);

		environment.jersey().register(resource);
	}
}
