import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class RestApplication extends ResourceConfig {

	public RestApplication() {
		packages("resource");
	}

}
