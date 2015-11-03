package org.squandered.weather.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by turnerc on 3/11/2015.
 */
public class AppHealthCheck extends HealthCheck {


	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}
