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

@Kroll.module(name = "Flic", id = "ti.flic")
public class FlicModule extends KrollModule {
	@Kroll.constant
	public int BUTTON_CONNECTION_COMPLETED = FlicButton.BUTTON_CONNECTION_COMPLETED;
	@Kroll.constant
	public int BUTTON_CONNECTION_STARTED = FlicButton.BUTTON_CONNECTION_STARTED;
	@Kroll.constant
	public int BUTTON_DISCONNECTED = FlicButton.BUTTON_DISCONNECTED;

	static String appId;
	static String appSecret;
	static String appName;

	public FlicModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Config.setFlicCredentials();
	}
}
