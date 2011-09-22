package com.moxoed.pgPlugin.hockeyGlue;

/*
import android.app.Activity;
import net.hockeyapp.android.CheckUpdateTask;
*/
import android.util.Log;

public class HockeyGlue {
	
//	private CheckUpdateTask checkUpdateTask;

    public void checkForUpdates() {
    	Log.d("HockeyGlue", "checkForUpdates-did-I-get-here");
/*
         checkUpdateTask = (CheckUpdateTask)getLastNonConfigurationInstance();
 
        if (checkUpdateTask != null) {
          checkUpdateTask.attach(this);
        }
        else {
          checkUpdateTask = new CheckUpdateTask(this, "https://rink.hockeyapp.net/", "dedae71020c1c014120ef0153cb8457c");
          checkUpdateTask.execute();
        }
*/
    }
}

