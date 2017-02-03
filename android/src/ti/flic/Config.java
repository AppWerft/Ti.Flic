package ti.flic;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;

import io.flic.lib.FlicManager;

public class Config {
	static String flicId;
	static String flicSecret;
	static String flicName;

	static void setFlicCredentials() {
		TiProperties appProperties = TiApplication.getInstance()
				.getAppProperties();
		flicId = appProperties.getString("FLIC_ID", "");
		flicSecret = appProperties.getString("FLIC_SECRET", "");
		flicName = appProperties.getString("FLIC_NAME", "");
		FlicManager.setAppCredentials(flicId, flicSecret, flicName);
	}

	static void setFlicCredentials(KrollDict kd) {
		if (kd.containsKeyAndNotNull("appID")) {
			flicId = kd.getString("appID");
		}
		if (kd.containsKeyAndNotNull("appSecret")) {
			flicSecret = kd.getString("appSecret");

		}
		if (kd.containsKeyAndNotNull("appName")) {
			flicName = kd.getString("appName");
		}
		FlicManager.setAppCredentials(flicId, flicSecret, flicName);
	}
}