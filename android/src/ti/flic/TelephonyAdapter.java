package ti.flic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.appcelerator.kroll.common.Log;

public class TelephonyAdapter {
	final static String TELEPHONYCLASS = "de.appwerft.telephonyutils.TelephoneyutilsModule";

	public static void start(String action) {
		// https://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/
		if (isModuleInstalled(TELEPHONYCLASS)) {
			// try to start statement:
			Class<?> clazz;
			try {
				clazz = Class.forName(TELEPHONYCLASS);
				Class<?> noparams[] = {};
				Method method;
				if (action.equals("dblclick")) {
					method = clazz.getDeclaredMethod("toggleLoudspeaker",
							noparams);
					method.setAccessible(true);
					method.invoke(null);
				}
				if (action.equals("longpress")) {
					method = clazz.getDeclaredMethod("finishCall", noparams);
					method.setAccessible(true);
					method.invoke(null);
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
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else
			Log.w("Ti", "module 'de.appwerft.telephonyutls' not installed");
	}

	private static boolean isModuleInstalled(String fqclassname) {
		try {
			Class.forName(fqclassname);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

}
