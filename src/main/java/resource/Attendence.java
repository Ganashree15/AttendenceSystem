package resource;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import config.ApplicationConfig;

public class Attendence {

	public static void main(String args[]) {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		ResourceConfig config = new ApplicationConfig();
		config.register(JacksonFeature.class);
		Server server = JettyHttpContainerFactory.createServer(baseUri, config, false);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			try {
				server.stop();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
