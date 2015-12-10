package config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(new ApplicationBinder());

		packages(true, "api");
	}
}