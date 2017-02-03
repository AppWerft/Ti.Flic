package ti.flic;

// http://www.nada.kth.se/~ameier/flic/guidelines/android/

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;

import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import android.content.Context;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	private TiApplication instance;
	private String LCAT = FlicModule.LCAT;

	public TiFlicBroadcastReceiver() {
		Log.d(LCAT, "create TiFlicBroadcastReceiver");
		instance = TiApplication.getInstance();
	}

	@Override
	protected void onRequestAppCredentials(Context ctx) {
		Log.d(LCAT, "onRequestAppCredentials");
		Config.setFlicCredentials();
	}

	@Override
	public void onButtonUpOrDown(Context context, FlicButton button,
			boolean wasQueued, int timeDiff, boolean isUp, boolean isDown) {
		Log.d(LCAT, "onButtonUpOrDown");
		KrollDict event = new KrollDict();
		event.put("timeDiff", timeDiff);
		event.put("UUID", button.getButtonId());
		event.put("buttonName", button.getName());

		if (isUp) {
			event.put("action", "down");
		} else {
			event.put("action", "up");
		}

		instance.fireAppEvent("flic", event);
	}

	@Override
	public void onButtonRemoved(Context context, FlicButton button) {
		Log.d(LCAT, "onButtonRemoved");
		KrollDict event = new KrollDict();
		event.put("removed", true);
		TiApplication.getInstance().fireAppEvent("flicbutton", event);
		// FlicModule.fireEvent("flicbutton", event);
	}
}