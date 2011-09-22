package com.moxoed.pgPlugin.hockeyapp;


import android.util.Log;
import org.json.JSONArray;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;
import com.moxoed.pgPlugin.hockeyGlue.HockeyGlue;

public class HockeyApp extends Plugin {
	
	private HockeyGlue hockeyGlue;
	
	public PluginResult execute(String action, JSONArray data, String callbackId) {
		Log.d("HockeyApp", "Plugin called");
		PluginResult result = null;
		//result = new PluginResult(Status.OK);
		//return result;
		/**/
		if (action.equals("checkForUpdate") ){
			Log.d("HockeyApp", "call hockeyGlue.checkForUpdates");
			hockeyGlue.checkForUpdates();
			Log.d("HockeyApp", "after call");
			result = new PluginResult(Status.OK);
		}
		return result;
		/**/
   }
}


 
