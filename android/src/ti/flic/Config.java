package ti.flic;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;

import io.flic.lib.FlicManager;

public class Config {
	static void setFlicCredentials() {
		TiProperties appProperties = TiApplication.getInstance()
				.getAppProperties();
		String appId = appProperties.getString("FLIC_ID", "");
		String appSecret = appProperties.getString("FLIC_SECRET", "");
		String appName = appProperties.getString("FLIC_NAME", "");
		FlicManager.setAppCredentials(appId, appSecret, appName);
	}
}