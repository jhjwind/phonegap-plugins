package com.moxoed;

import com.phonegap.*;
import android.os.Bundle;
import net.hockeyapp.android.CheckUpdateTask;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateActivity;

public class PgHockeyAppActivity extends DroidGap {
	private CheckUpdateTask checkUpdateTask;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        UpdateActivity.iconDrawableId = R.drawable.icon;
        checkForUpdates();
    }
    
    @Override
    public void onResume() {
      super.onResume();
      checkForCrashes();
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
      checkUpdateTask.detach();
      return checkUpdateTask;
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