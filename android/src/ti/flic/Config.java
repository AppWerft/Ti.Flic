package ti.flic;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;

import io.flic.lib.FlicManager;

public class Config {
	static void setFlicCredentials() {
		TiProperties appProperties = TiApplication.getInstance()
				.getAppProperties();
		FlicManager.setAppCredentials(appProperties.getString("FLIC_ID", ""),
				appProperties.getString("FLIC_SECRET", ""),
				appProperties.getString("FLIC_NAME", ""));
	}
}