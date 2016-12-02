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
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;
import org.appcelerator.titanium.util.TiActivityResultHandler;
import org.appcelerator.kroll.common.Log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

@Kroll.module(name = "Flic", id = "ti.flic")
public class FlicModule extends KrollModule implements TiActivityResultHandler {

	private static final String LCAT = "FickModule";
	private Context ctx;
	static String appId;
	static String appSecret;
	static String appName;

	public FlicModule() {
		super();
		ctx = TiApplication.getInstance();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Config.setFlicCredentials();
	}

	@Kroll.method
	public void Init() {
		/*
		 * We will now use the manager that can be used to grab a button from
		 * the Flic app. The Flic app will be opened up, and the user will be
		 * prompted to select one of his/her connected buttons. It will then
		 * send information about the button back to our app so that we can
		 * start using it. In an activity, this code is used to grab a button.
		 */
		try {
			FlicManager.getInstance(ctx, new FlicManagerInitializedCallback() {

				@Override
				public void onInitialized(FlicManager manager) {
					manager.initiateGrabButton(TiApplication
							.getAppRootOrCurrentActivity());
				}

			});
		} catch (FlicAppNotInstalledException err) {
			if (hasListeners("error")) {
				fireEvent("error", new KrollDict());
			}
			Log.e(LCAT, "Flic App is not installed");
		}
	}

	/*
	 * To receive the button object, we must feed the result into the manager
	 * which then returns the button object. With the button object, we register
	 * for notifications. In this example, we’re only interested in down, up and
	 * remove events.
	 */
	@Override
	public void onResult(Activity activity, final int requestCode,
			final int resultCode, final Intent data) {
		FlicManager.getInstance(ctx, new FlicManagerInitializedCallback() {
			@Override
			public void onInitialized(FlicManager manager) {
				FlicButton button = manager.completeGrabButton(requestCode,
						resultCode, data);
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

	@Override
	public void onError(Activity arg0, int arg1, Exception arg2) {
	}

}
