#Ti.Flic


<img src="https://slack-imgs.com/?c=1&url=http%3A%2F%2Fflic.io%2Fassets%2Fimg%2Fflic_logo_black.jpg" width=240 />

Ti.Flic is an open-source project to support the Flic Android-SDK in Appcelerator's Titanium Mobile. The IOS-version from Hansemann you can find [here](https://github.com/hansemannn/ti.flic).

Unfortunately is a 100% parity of signature not possible. It is because different architecture of both native SDKs.   


The first thing we need to do is to make sure you have the Flic app installed. 
Why do I need the Flic app? The fliclib works with the Flic app so that you don't have to worry about handling the Flics, scanning the Flics, or monitoring the communication with them. All of that is taken care of by the Flic app.

1.  Download and install the Flic app. It's free and you can find it in the Google Play Store.
2.  Connect all your Flics to the app.
3.   That's it! Now you will be able to use the Flic Grabber and get access to the Flics inside your own app. Don't worry, we'll go through how this is done soon.

For usage inside a Titanium app you have to insert 3 parameters in your tiapp.xml:
```xml
<property name="FLIC_ID" type="String"></property>
<property name="FLIC_SECRET" type="String"></property>
<property name="FLIC_NAME" type="String"></property>
```
The appId and appSecret are unique for every application and can be generated on [developer portal of flic](https://partners.flic.io/partners/developers/credentials).
The appName should be the friendly name of your app. 

In your tiapp.xml (or manifest) you have to put:

```xml
<receiver
  android:name=".TiFlicBroadcastReceiver"
  android:enabled="true"
  android:exported="true" >
    <intent-filter>
      <action android:name="io.flic.FLICLIB_EVENT" />
    </intent-filter>
</receiver>
```
##Constants
```java
var Flic = require("ti.flic");
Flic.BUTTON_CONNECTION_COMPLETED;
Flic.BUTTON_CONNECTION_STARTED;
Flic.BUTTON_DISCONNECTED;
Flic.TRIGGER_BEHAVIOR_ALL
Flic.TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK
Flic.TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK_OR_HOLD
Flic.TRIGGER_BEHAVIOR_CLICK_OR_HOLD
Flic.TRIGGER_BEHAVIOR_NONE
Flic.TRIGGER_BEHAVIOR_REMOVED
Flic.TRIGGER_BEHAVIOR_UP_OR_DOWN
```

##Usage:

```javascript
var Flic = require("ti.flic");
Flic.grabFlicFromFlicApp({
	onsuccess : handleFlicGrabEvent, // getting UUID + buttonName, ...
	onerror : handleWarningAboutFlicApp
});
	

//Button events (even app is not running	)
Ti.App.addEventListener("flic",handleFlicButtonEvent); // getting UUID, buttonName, up/down
Flic.forgetButton(UUID);
Flic.getKnownButtons(); // returns list of name + uuid
Flic.isEnabled();
Flic.getButtonByUUID(uuid);
Flic.updateButtonTriggerBehavior(behavior);
```
`behavior` can be
```
Flic.TRIGGER_BEHAVIOR_ALL
Flic.TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK
Flic.TRIGGER_BEHAVIOR_CLICK_OR_DOUBLE_CLICK_OR_HOLD
Flic.TRIGGER_BEHAVIOR_CLICK_OR_HOLD
Flic.TRIGGER_BEHAVIOR_NONE
Flic.TRIGGER_BEHAVIOR_REMOVED
Flic.TRIGGER_BEHAVIOR_UP_OR_DOWN
```