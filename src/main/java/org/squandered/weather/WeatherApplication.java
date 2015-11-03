package org.squandered.weather;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.squandered.weather.health.AppHealthCheck;
import org.squandered.weather.resource.WeatherResource;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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

		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

		final WeatherResource resource = new WeatherResource(
			configuration.getDefaultLatitude(),
			configuration.getDefaultLongitude()
		);

		environment.jersey().register(resource);
		environment.healthChecks().register("app-alive", new AppHealthCheck());
	}
}
