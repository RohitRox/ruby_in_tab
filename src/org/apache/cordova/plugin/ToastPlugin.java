package org.apache.cordova.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

public class ToastPlugin extends CordovaPlugin {

	public final String ACTION_SHOW = "Show";
	public final String ACTION_SHORT_SHOW = "ShortShow";
	public final String ACTION_LONG_SHOW = "LongShow";
	
	@Override
	public boolean execute(String action, JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
		
		String text;
		int duration;
		try {
			text = args.getString(0);
		} catch (JSONException e) {
			callbackContext.sendPluginResult(
					new PluginResult(PluginResult.Status.ERROR, "Parsing Text Exception"));
		
			return true;
		} 
		
		if (action.equals(ACTION_SHOW)) {

			try {
				duration = args.getInt(1);
			} catch (JSONException e) {
				callbackContext.sendPluginResult(
						new PluginResult(PluginResult.Status.ERROR, "Parsing Duration Exception"));
				return true;
			}
			
			Toast.makeText(cordova.getActivity(), text, duration).show();
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, true));
			return true;
		}
		else if (action.equals(ACTION_SHORT_SHOW)) {
			Toast.makeText(cordova.getActivity(), text, Toast.LENGTH_SHORT).show();
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, true));
			return true;
		}
		else if (action.equals(ACTION_LONG_SHOW)) {
			Toast.makeText(cordova.getActivity(), text, Toast.LENGTH_LONG).show();
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, true));
			return true;
		}
		return false;
	}
}