package ti.flic;

import java.io.IOException;
import java.io.InputStream;

import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.io.TiFileFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FlicTelephonyGateway {
	public String getClickMethod() {
		return clickMethod;
	}

	public String getLongpressMethod() {
		return longpressMethod;
	}

	public String getDblclickMethod() {
		return dblclickMethod;
	}

	public String getNumber() {
		return number;
	}

	public String getFullqualifiedClassname() {
		return fullqualifiedClassname;
	}

	private String fullqualifiedClassname;
	private String clickMethod;
	private String longpressMethod;
	private String dblclickMethod;
	private String number;

	public FlicTelephonyGateway() {
		importJSON();
	}

	private boolean importJSON() {
		try {
			JSONObject json = new JSONObject(loadJSONFromAsset());
			number = json.getString("number");
			fullqualifiedClassname = json.getString("endpoint");
			JSONArray actions = json.getJSONArray("actions");
			for (int i = 0; i < actions.length(); i++) {
				JSONObject action = actions.getJSONObject(i);

				switch (action.getString("action")) {
				case "click":
					clickMethod = action.getString("method");
					break;
				case "dblclick":
					dblclickMethod = action.getString("method");
					break;
				case "longpress":
					longpressMethod = action.getString("method");
					break;

				}
			}
			return true;
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}

	private String loadJSONFromAsset() {
		String json = null;
		try {
			InputStream inStream = TiFileFactory.createTitaniumFile(
					new String[] { FlicModule.configUri }, false)
					.getInputStream();
			byte[] buffer = new byte[inStream.available()];
			inStream.read(buffer);
			inStream.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;
	}
}
