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
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;
import io.flic.lib.FlicManagerInitializedCallback;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;

import android.content.Context;

// This proxy can be created by calling Oaipmh.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = FlicModule.class)
public class ButtonManagerProxy extends KrollProxy {
	private static final String LCAT = "";
	Context ctx = TiApplication.getInstance().getApplicationContext();
	KrollFunction onErrorCallback;
	KrollFunction onGrabCallback;
	private FlicManager flicManager;

	// Constructor
	public ButtonManagerProxy() {
		super();
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
		init();

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

	private void init() {
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
					flicManager = manager;
					flicManager.initiateGrabButton(TiApplication
							.getAppRootOrCurrentActivity());
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