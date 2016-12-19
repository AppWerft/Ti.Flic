package ti.flic;

import io.flic.lib.FlicAppNotInstalledException;
import io.flic.lib.FlicBroadcastReceiverFlags;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;
import io.flic.lib.FlicManagerInitializedCallback;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiMessenger;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiActivityResultHandler;
import org.appcelerator.titanium.util.TiActivitySupport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

// This proxy can be created by calling Oaipmh.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = FlicModule.class)
public class ButtonManagerProxy extends KrollProxy {
	private static final String LCAT = "TiFlic";
	Context ctx = TiApplication.getInstance().getApplicationContext();
	KrollFunction onErrorCallback;
	KrollFunction onGrabCallback;

	FlicManager flicManager;

	// Constructor
	public ButtonManagerProxy() {
		super();
		Log.d(LCAT, "ButtonManagerProxy constructor");
	}

	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		if (options.containsKeyAndNotNull("onsuccess")) {
			onGrabCallback = (KrollFunction) options.get("onsuccess");
		}
		if (options.containsKeyAndNotNull("onerror")) {
			onErrorCallback = (KrollFunction) options.get("onerror");
		}

	}

	@Kroll.method
	public void forgetButton(String uuid) {
		flicManager.forgetButton(flicManager.getButtonByDeviceId(uuid));
	}

	@Kroll.method
	public KrollDict getKnownButtons() {
		KrollDict result = new KrollDict();
		for (FlicButton button : flicManager.getKnownButtons()) {
			result.put("name", button.getName());
			result.put("uuid", button.getButtonId());
		}
		return result;
	}

	@Kroll.method
	public void initiateGrabButton() {
		/*
		 * We will now use the manager that can be used to grab a button from
		 * the Flic app. The Flic app will be opened up, and the user will be
		 * prompted to select one of his/her connected buttons. It will then
		 * send information about the button back to our app so that we can
		 * start using it. In an activity, this code is used to grab a button.
		 */
		Log.d(LCAT, "initiateGrabButton");
		final TiActivityResultHandler resultHandler = new TiActivityResultHandler() {

			@Override
			public void onResult(Activity activity, final int requestCode,
					final int resultCode, final Intent data) {
				FlicManager.getInstance(ctx,
						new FlicManagerInitializedCallback() {
							@Override
							public void onInitialized(FlicManager flicManager) {
								Log.d(LCAT, "onInitialized");
								ButtonManagerProxy.this.flicManager = flicManager;
								FlicButton button = flicManager
										.completeGrabButton(requestCode,
												resultCode, data);
								KrollDict event = new KrollDict();
								if (button != null) {
									button.registerListenForBroadcast(FlicBroadcastReceiverFlags.UP_OR_DOWN
											| FlicBroadcastReceiverFlags.REMOVED);
									event.put("message", "Grabbed a button");
									event.put("grabbed", true);
									event.put("UUID", button.getButtonId());
									event.put("button", button.toString());
									event.put("status",
											button.getConnectionStatus());
									event.put("buttonName", button.getName());
									Log.d(LCAT, event.toString());
									if (onGrabCallback != null) {
										onGrabCallback.call(getKrollObject(),
												event);
									}
								} else {
									event.put("message",
											"Did not grab any button");
									event.put("grabbed", false);
								}
								if (hasListeners("error"))
									fireEvent("error", event);
							}
						});

			}

			@Override
			public void onError(Activity activity, int requestCode, Exception e) {
			}
		};

		try {
			FlicManager.getInstance(ctx, new FlicManagerInitializedCallback() {
				final TiActivitySupport activitySupport = (TiActivitySupport) TiApplication
						.getInstance().getCurrentActivity();

				@Override
				public void onInitialized(final FlicManager flicManager) {
					// ButtonManagerProxy.this.flicManager = flicManager;

					if (TiApplication.isUIThread()) {
						activitySupport.launchActivityForResult(
								flicManager.createIntentForInitiateGrabButton(),
								FlicManager.GRAB_BUTTON_REQUEST_CODE,
								resultHandler);
					} else {
						TiMessenger.postOnMain(new Runnable() {
							@Override
							public void run() {
								activitySupport.launchActivityForResult(
										flicManager
												.createIntentForInitiateGrabButton(),
										FlicManager.GRAB_BUTTON_REQUEST_CODE,
										resultHandler);
							}
						});
					}
				}
			});
		} catch (FlicAppNotInstalledException err) {
			if (hasListeners("error")) {
				fireEvent("error", new KrollDict());
			}
			if (onGrabCallback != null) {
				onGrabCallback.call(getKrollObject(), new KrollDict());
			}
			Log.e(LCAT, "Flic App is not installed");
		}
	}

}
