/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.flic;

import io.flic.lib.FlicButton;

import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;

@Kroll.proxy(creatableInModule = FlicModule.class)
public class ButtonProxy extends KrollProxy {
	private FlicButton flicButton;

	public void createButton(FlicButton button) {
		flicButton = button;
	}

	public ButtonProxy() {
		super();
	}
}