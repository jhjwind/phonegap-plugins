package com.moxoed.pgPlugin.hockeyGlue;

import android.app.Activity;
import net.hockeyapp.android.CheckUpdateTask;
//import net.hockeyapp.android.UpdateActivity;
import android.util.Log;
import android.os.Bundle;

public class HockeyGlue extends Activity{
	private CheckUpdateTask checkUpdateTask;
    @Override
    public void onCreate(Bundle savedInstanceState) {

    	Log.d("HH","jj");
    }
	    public void checkForUpdates() {
	    	Log.d("HockeyGlue", "checkForUpdates-did-I-get-here");
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

