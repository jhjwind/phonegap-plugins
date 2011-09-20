package com.moxoed;

//import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;
import net.hockeyapp.android.CheckUpdateTask;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateActivity;

public class HockeyAppActivity extends DroidGap { //from Activity
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html"); //setContentView(R.layout.main);
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
      CrashManager.register(this, "https://rink.hockeyapp.net/", "PUBLIC ID");
    }

    private void checkForUpdates() {
      checkUpdateTask = (CheckUpdateTask)getLastNonConfigurationInstance();
      if (checkUpdateTask != null) {
        checkUpdateTask.attach(this);
      }
      else {
        checkUpdateTask = new CheckUpdateTask(this, "https://rink.hockeyapp.net/", "PUBLIC ID");
        checkUpdateTask.execute();
      }
    }
}