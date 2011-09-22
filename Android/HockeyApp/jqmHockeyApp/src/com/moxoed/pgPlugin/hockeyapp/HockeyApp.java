package com.moxoed.pgPlugin.hockeyapp;


import android.util.Log;
import org.json.JSONArray;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;

public class HockeyApp extends Plugin {
	@Override
	public PluginResult execute(String action, JSONArray data, String callbackId) {
		Log.d("HockeyAppPlugin", "Plugin called");
		PluginResult result = null;
		if (action.equals("checkForUpdate") ){
			Log.d("HockeyApp", "checkForUpdate");
			// checkForUpdates()
			result = new PluginResult(Status.OK);
		}
		return result;
		
   }
}
