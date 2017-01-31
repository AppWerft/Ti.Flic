package ti.flic;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;

import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import android.content.Context;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	private TiApplication instance;

	public TiFlicBroadcastReceiver() {
		instance = TiApplication.getInstance();
	}

	@Override
	protected void onRequestAppCredentials(Context ctx) {
		Config.setFlicCredentials();
	}

	@Override
	public void onButtonUpOrDown(Context context, FlicButton button,
			boolean wasQueued, int timeDiff, boolean isUp, boolean isDown) {
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
		KrollDict event = new KrollDict();
		event.put("removed", true);
		TiApplication.getInstance().fireAppEvent("flicbutton", event);
		FlicModule.fireEvent("flicbutton", event);

	}
}