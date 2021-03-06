package ti.flic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;

public class TelephonyAdapter {
	final static String TELEPHONYCLASS = "de.appwerft.telephonyutils.TelephonyutilsModule";
	final static String LCAT = FlicModule.LCAT;

	public static void procede(String action) {
		Log.d(LCAT, "start TelephonyUtils with " + action);
		// https://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/
		if (isModuleInstalled(TELEPHONYCLASS)) {
			Log.d(LCAT, TELEPHONYCLASS + " is installed");
			Class<?> clazz;
			Class<?> noparams[] = {};
			try {
				clazz = Class.forName(TELEPHONYCLASS);
				Method method = null;
				switch (action) {
				case "dblclick":
					method = clazz.getDeclaredMethod("toggleLoudspeaker",
							noparams);
					break;
				case "longpress":
					method = clazz.getDeclaredMethod("finishCall", noparams);
					break;
				case "click":
					method = clazz.getDeclaredMethod("call", noparams);
				}
				method.setAccessible(true);
				method.invoke(clazz.newInstance(), (Object[]) null);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				Log.e(LCAT, e.getMessage());
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		} else
			Log.w("Ti", "module '" + TELEPHONYCLASS + "' not installed");
	}

	private static boolean isModuleInstalled(String fqclassname) {
		Log.d(LCAT, "test of '" + fqclassname + "'");
		try {
			Class.forName(fqclassname);
			Log.d(LCAT, "class  found");
			return true;
		} catch (ClassNotFoundException e) {
			Log.d(LCAT, e.getMessage());
			return false;
		}
	}

}
