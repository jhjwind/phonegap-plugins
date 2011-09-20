/**
 * 
 */
package com.moxoed.phonegap.plugin.hockeyapp;

/**
 * @author owenbrotherwood
 *
 */

import org.json.JSONArray;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;
import net.hockeyapp.android.CheckUpdateTask;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateActivity;

public class HockeyAppPlugin extends Plugin{
	
	@Override
	public PluginResult execute(String action, JSONArray data, String callbackId) {
		PluginResult result = null;
		if (action.equals("checkForUpdate") ){
			CheckForUpdates();
			result = new PluginResult(Status.OK);
		}
		return result;
   }

	private void checkForCrashes() {
        CrashManager.register(this, "https://rink.hockeyapp.net/", "dedae71020c1c014120ef0153cb8457c");
    }

    private void checkForUpdates() {
        checkUpdateTask = (CheckUpdateTask)getLastNonConfigurationInstance();
        if (checkUpdateTask != null) {
          checkUpdateTask.attach(this);
        }
        else {
          checkUpdateTask = new CheckUpdateTask(this, "https://rink.hockeyapp.net/", "dedae71020c1c014120ef0153cb8457c");
          checkUpdateTask.execute();
        }
    }	
}
