#Ti.Flic
<img src="https://cdn.shopify.com/s/files/1/1089/5800/products/flic-teal-grey.jpg?v=1475748747" width=200 />
This is the Titanium module for flic. It is still in working progress.
The first thing we need to do is to make sure you have the Flic app installed. 
 Why do I need the Flic app? The fliclib works with the Flic app so that you don't have to worry about handling the Flics, scanning the Flics, or monitoring the communication with them. All of that is taken care of by the Flic app.

1.    Download and install the Flic app. It's free and you can find it in the Google Play Store.
2.    Connect all your Flics to the app.
3.    That's it! Now you will be able to use the Flic Grabber and get access to the Flics inside your own app. Don't worry, we'll go through how this is done soon.

For usage inside a Titanium app you have to insert 3 paramters in your tiapp.xml:
```xml
<property name="appId" type="string"></property>
<property name="appSecret" type="string"></property>
<property name="appName" type="string"></property>
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

##Usage:

```javascript
var Flic = require("ti.flic");
Flic.init();
Flic.addEventListener("noflicapp",handleWarningAboutFlicApp);


```