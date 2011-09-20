package com.moxoed.PhoneGapHockeyAppPlugin;


import net.hockeyapp.android.CheckUpdateTask;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateActivity;
import android.app.Activity;
import com.phonegap.*;
import android.os.Bundle;
import android.view.View;


public class PhoneGapHockeyAppPluginActivity extends DroidGap {
	private CheckUpdateTask checkUpdateTask; // needed but not @ http://support.hockeyapp.net/kb/client-integration/hockeyapp-for-android	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        // Set icon drawable
        UpdateActivity.iconDrawableId = R.drawable.icon;
        
        // Check for updates
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