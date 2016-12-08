#Ti.Flic


<img src="https://slack-imgs.com/?c=1&url=http%3A%2F%2Fflic.io%2Fassets%2Fimg%2Fflic_logo_black.jpg" width=240 />

Ti.Flic is an open-source project to support the Flic Android-SDK in Appcelerator's Titanium Mobile. The IOS-version from Hansemann you can find [here](https://github.com/hansemannn/ti.flic).

This module is highly work in progress and should not be used in any productional environment!
 Hint: send me a button and then I can test and complete the module. ;-)

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
  android:name=".TiBroadcastReceiver"
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
```

##Usage:

```javascript
var Flic = require("ti.flic");
var flicManager = Flic.createFlicMananger({
	onsuccess : handleFlicGrabEvent, // getting UUID + buttonName, ...
	onerror : handleWarningAboutFlicApp
});

//Button events (even app is not running	)
Ti.App.addEventListener("flicbutton",handleFlicButtonEvent); // getting UUID, buttonName, up/down

flicManager.forgetButton(UUID);
flicManager.getKnownButtons(); // returns list of name + uuid
```