package ti.flic;

import android.content.Context;
import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	@Override
	protected void onRequestAppCredentials(Context context) {
		FlicManager.setAppCredentials(FlicModule.appId, FlicModule.appSecret,
				FlicModule.appName);

	}

	@Override
	public void onButtonUpOrDown(Context context, FlicButton button,
			boolean wasQueued, int timeDiff, boolean isUp, boolean isDown) {
		if (isUp) {
			// Code for button up event here
		} else {
			// Code for button down event here
		}
	}

	@Override
	public void onButtonRemoved(Context context, FlicButton button) {
		// Button was removed
	}

}