package com.moxoed.jqmHockeyApp;

import com.phonegap.*;
import android.os.Bundle;
import net.hockeyapp.android.CheckUpdateTask;
//import net.hockeyapp.android.UpdateActivity;

public class JqmHockeyAppActivity extends DroidGap {
	private CheckUpdateTask checkUpdateTask;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        checkForUpdates();
    }
    
    @Override
    public Object onRetainNonConfigurationInstance() {
      checkUpdateTask.detach();
      return checkUpdateTask;
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