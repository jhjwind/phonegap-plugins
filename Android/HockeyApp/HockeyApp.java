package com.moxoed.pgPlugin.hockeyapp;

import org.json.JSONArray;

import android.util.Log;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;

public class HockeyApp extends Plugin {
	public PluginResult execute(String action, JSONArray data, String callbackId) {
		Log.d("HockeyApp", "Plugin called");
		PluginResult result = null;
		result = new PluginResult(Status.OK);
		return result;
   }
}


 
