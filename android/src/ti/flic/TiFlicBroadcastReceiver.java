package ti.flic;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;

import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import android.content.Context;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	@Override
	protected void onRequestAppCredentials(Context ctx) {
		Config.setFlicCredentials();
	}

	@Override
	public void onButtonUpOrDown(Context context, FlicButton button,
			boolean wasQueued, int timeDiff, boolean isUp, boolean isDown) {
		KrollDict event = new KrollDict();
		event.put("timeDiff", timeDiff);
		if (isUp) {
			event.put("action", "down");
		} else {
			event.put("action", "up");
		}
		TiApplication.getInstance().fireAppEvent("flic", event);
	}

	@Override
	public void onButtonRemoved(Context context, FlicButton button) {
		KrollDict event = new KrollDict();
		event.put("removed", true);
		TiApplication.getInstance().fireAppEvent("flic", event);
	}
}