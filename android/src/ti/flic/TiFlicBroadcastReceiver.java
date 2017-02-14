package ti.flic;

// http://www.nada.kth.se/~ameier/flic/guidelines/android/

import org.appcelerator.kroll.KrollDict;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;

import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import android.content.Context;

public class TiFlicBroadcastReceiver extends FlicBroadcastReceiver {
	private String LCAT = FlicModule.LCAT;
	KrollModule module;

	public TiFlicBroadcastReceiver() {
		// instance = TiApplication.getInstance();
	}

	private void sendJS(String action, KrollDict evt) {
		TiApplication app = TiApplication.getInstance();
		evt.put("action", action);
		app.fireAppEvent("flic", evt);
		app.fireAppEvent("flic_" + action, evt);
		Log.d(LCAT, evt.toString());
	}

	@Override
	protected void onRequestAppCredentials(Context ctx) {
		Log.d(LCAT, "onRequestAppCredentials");
		Config.setFlicCredentials();
	}

	@Override
	public void onButtonSingleOrDoubleClickOrHold(Context ctx,
			FlicButton button, boolean wasQueued, int timeDiff,
			boolean isSingleClick, boolean isDoubleClick, boolean isHold) {
		KrollDict event = new KrollDict();
		event.put("timeDiff", timeDiff);
		event.put("UUID", button.getButtonId());
		event.put("name", button.getName());
		event.put("color", button.getColor());
		event.put("queued", wasQueued);
		String action = "";
		if (isHold) {
			action = "longpress";
		}
		if (isSingleClick) {
			action = "click";
		}
		if (isDoubleClick) {
			action = "dblclick";
		}
		sendJS(action, event);
		TelephonyAdapter.procede(event.getString("action"));
	}

	@Override
	public void onButtonRemoved(Context context, FlicButton button) {
		Log.d(LCAT, "onButtonRemoved");
		KrollDict event = new KrollDict();
		event.put("removed", true);
		sendJS("removed", event);
	}
}