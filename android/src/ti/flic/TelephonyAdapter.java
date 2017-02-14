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
			// try to start statement:
			Class<?> clazz;
			Object instance;
			try {
				clazz = Class.forName(TELEPHONYCLASS);
				instance = clazz.newInstance();

				Class<?> noparams[] = {};
				Method method;
				if (action.equals("dblclick")) {
					method = clazz.getDeclaredMethod("toggleLoudspeaker",
							noparams);
					method.setAccessible(true);
					method.invoke(instance, null);
				}
				if (action.equals("longpress")) {
					method = clazz.getDeclaredMethod("finishCall", noparams);
					method.setAccessible(true);
					method.invoke(instance, null);
				}
				if (action.equals("click")) {
					String phoneNumber = "+"
							+ TiApplication.getInstance().getAppProperties()
									.getString("FLIC_EMERGENCYNUMBER", "");
					@SuppressWarnings("rawtypes")
					Class[] paramString = new Class[1];
					paramString[0] = String.class;
					method = clazz.getDeclaredMethod("callNumber", paramString);
					method.invoke(instance, new String(phoneNumber));
				}
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
