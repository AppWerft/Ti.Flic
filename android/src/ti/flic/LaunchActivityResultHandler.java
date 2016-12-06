package ti.flic;

import io.flic.lib.FlicBroadcastReceiverFlags;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;
import io.flic.lib.FlicManagerInitializedCallback;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.util.TiActivityResultHandler;

import android.app.Activity;
import android.content.Intent;

public class LaunchActivityResultHandler implements TiActivityResultHandler {

	@Override
	public void onError(Activity activity, int requestCode, Exception e) {
	}

	@Override
	public void onResult(Activity activity, int requestCode, int resultCode,
			Intent intent) {
		FlicManager.getInstance(ctx, new FlicManagerInitializedCallback() {
			@Override
			public void onInitialized(FlicManager flicManager) {
				FlicButton button = flicManager.completeGrabButton(requestCode,
						resultCode, intent);
				KrollDict event = new KrollDict();
				if (button != null) {
					button.registerListenForBroadcast(FlicBroadcastReceiverFlags.UP_OR_DOWN
							| FlicBroadcastReceiverFlags.REMOVED);
					event.put("message", "Grabbed a button");
					event.put("grabbed", true);
					event.put("UUID", button.getButtonId());
					event.put("buttonName", button.getName());
				} else {
					event.put("message", "Did not grab any button");
					event.put("grabbed", false);
				}
				if (hasListeners("error"))
					fireEvent("success", event);
			}
		});
	}
}