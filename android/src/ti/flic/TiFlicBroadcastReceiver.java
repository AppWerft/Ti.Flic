package ti.flic;

import android.content.Context;
import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	@Override
	protected void onRequestAppCredentials(Context context) {
		// Set app credentials by calling FlicManager.setAppCredentials here
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