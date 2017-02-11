/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.flic;

import io.flic.lib.FlicAppNotInstalledException;
import io.flic.lib.FlicBroadcastReceiverFlags;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;
import io.flic.lib.FlicManagerInitializedCallback;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiMessenger;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiActivityResultHandler;
import org.appcelerator.titanium.util.TiActivitySupport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

@Kroll.module(name = "Flic", id = "ti.flic")
public class FlicModule extends KrollModule {
	private final class OnInitializedHandler implements
			FlicManagerInitializedCallback {
		private final Intent data;
		private final int requestCode;
		private final int resultCode;

		private OnInitializedHandler(Intent data, int requestCode,
				int resultCode) {
			this.data = data;
			this.requestCode = requestCode;
			this.resultCode = resultCode;
		}

		@Override
		public void onInitialized(FlicManager _flicManager) {
			Log.d(LCAT, "onInitialized");
			flicManager = _flicManager;
			FlicButton button = flicManager.completeGrabButton(requestCode,
					resultCode, data);
			KrollDict event = new KrollDict();
			if (button != null) {
				button.registerListenForBroadcast(FlicBroadcastReceiverFlags.ALL
						| FlicBroadcastReceiverFlags.REMOVED);
				event.put("message", "Grabbed a button");
				event.put("grabbed", true);
				event.put("UUID", button.getButtonId());
				event.put("status", button.getConnectionStatus());
				event.put("buttonName", button.getName());
				Log.d(LCAT, event.toString());
				if (hasListeners("grabbed")) {
					fireEvent("grabbed", event);
				}
				if (onGrabCallback != null) {
					onGrabCallback.call(getKrollObject(), event);
				}

			} else {
				event.put("message", "Did not grab any button");
				event.put("grabbed", false);
			}
			if (hasListeners("error"))
				fireEvent("error", event);
		}
	}

	@Kroll.constant
	public static final int BUTTON_CONNECTION_COMPLETED = FlicButton.BUTTON_CONNECTION_COMPLETED;
	@Kroll.constant
	public static final int BUTTON_CONNECTION_STARTED = FlicButton.BUTTON_CONNECTION_STARTED;
	@Kroll.constant
	public static final int BUTTON_DISCONNECTED = FlicButton.BUTTON_DISCONNECTED;

	static String appId;
	static String appSecret;
	static String appName;

	static final int TRIGGER_BEHAVIOR_ALL = FlicBroadcastReceiverFlags.ALL;
	static final int TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK = FlicBroadcastReceiverFlags.CLICK_OR_DOUBLE_CLICK;
	static final int TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK_OR_HOLD = FlicBroadcastReceiverFlags.CLICK_OR_DOUBLE_CLICK_OR_HOLD;
	static final int TRIGGER_BEHAVIOR_CLICK_OR_HOLD = FlicBroadcastReceiverFlags.CLICK_OR_HOLD;
	static final int TRIGGER_BEHAVIOR_NONE = FlicBroadcastReceiverFlags.NONE;
	static final int TRIGGER_BEHAVIOR_REMOVED = FlicBroadcastReceiverFlags.REMOVED;
	static final int TRIGGER_BEHAVIOR_UP_OR_DOWN = FlicBroadcastReceiverFlags.UP_OR_DOWN;

	public static final String LCAT = "TiFlic";
	Context ctx = TiApplication.getInstance().getApplicationContext();
	KrollFunction onErrorCallback;
	KrollFunction onGrabCallback;
	FlicManager flicManager;

	public FlicModule() {
		super();
		Log.d(LCAT, "Constructor!!!");
		try {
			FlicManager.getInstance(ctx, new FlicManagerInitializedCallback() {
				@Override
				public void onInitialized(FlicManager manager) {
					flicManager = manager;
					if (fireEvent("flic", "ready"))
						;
				}
			});
		} catch (FlicAppNotInstalledException err) {
		}
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Config.setFlicCredentials();
		Log.d(LCAT, "onAppCreate");

	}

	@Kroll.method
	public void grabFlicFromFlicAppWithCallbackUrlScheme(String dummyurl) {
		grabFlicFromFlicApp(new KrollDict());
	}

	@Kroll.method
	public void grabFlicFromFlicApp(
			@Kroll.argument(optional = true) KrollDict options) {
		importOptions(options);
		Log.d(LCAT, "initiateGrabButton");
		final TiActivityResultHandler resultHandler = new TiActivityResultHandler() {
			@Override
			public void onResult(Activity activity, final int requestCode,
					final int resultCode, final Intent data) {
				FlicManager.getInstance(ctx, new OnInitializedHandler(data,
						requestCode, resultCode));
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

	@Kroll.method
	public void configure(KrollDict kd) {
		Config.setFlicCredentials(kd);

	}

	@Kroll.method
	public boolean isEnabled() {
		return (flicManager != null && flicManager.isInitialized());
	}

	@Kroll.method
	public void enable() {
	}

	@Kroll.method
	public void disable() {
	}

	@Kroll.method
	KrollDict getButtonByUUID(String uuid) {
		KrollDict kd = new KrollDict();
		if (flicManager != null) {
			FlicButton flicButton = flicManager.getButtonByDeviceId(uuid);
			kd.put("uuid", uuid);
			if (flicButton != null) {
				kd.put("color", flicButton.getColor());
				kd.put("name", flicButton.getName());
				kd.put("uuid", flicButton.getButtonId());
				kd.put("remoteRSSI", flicButton.readRemoteRSSI());
			}
		}
		return kd;
	}

	@Kroll.method
	public void updateButtonTriggerBehavior(String uuid, int behavior) {
		if (flicManager != null) {
			FlicButton flicButton = flicManager.getButtonByDeviceId(uuid);
			flicButton.setFlicButtonCallbackFlags(behavior);
		}
	}

	@Kroll.method
	public void updateButtonLowLatencyMode(String uuid, boolean enableLowLatency) {
		FlicButton flicButton = flicManager.getButtonByDeviceId(uuid);

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

	private void importOptions(KrollDict options) {
		if (options.containsKeyAndNotNull("onsuccess")) {
			onGrabCallback = (KrollFunction) options.get("onsuccess");
		}
		if (options.containsKeyAndNotNull("onerror")) {
			onErrorCallback = (KrollFunction) options.get("onerror");
		}
	}

	private FlicManager getFlicManager() {
		if (flicManager != null)
			return flicManager;
		else
			Log.w(LCAT, "flicManager is null, call the method asyncronly");
		return null;
	}
}
