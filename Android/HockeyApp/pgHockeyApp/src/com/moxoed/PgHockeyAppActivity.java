package com.moxoed;

//import com.phonegap.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import net.hockeyapp.android.CheckUpdateTask;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateActivity;

public class PgHockeyAppActivity extends Activity {
	private CheckUpdateTask checkUpdateTask;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        super.loadUrl("file:///android_asset/www/index.html");
  
      System.setProperty("http.keepAlive", "false");

      UpdateActivity.iconDrawableId = R.drawable.icon;
      checkForUpdates();
    }
    
    @Override
    public void onResume() {
      super.onResume();
      checkForCrashes();
    }
    
    public void onClickCheckButton(View view) {
      checkForUpdates();
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

    @Override
    public Object onRetainNonConfigurationInstance() {
      checkUpdateTask.detach();
      return checkUpdateTask;
    }

    public void onClickCrashButton(View view) {
      // Find a view that does not exist
      View missing = (View)findViewById(R.id.icon_view);
      
      // This should raise a null pointer exception
      missing.bringToFront();
    }
    
    private void checkForCrashes() {
      CrashManager.register(this, "https://rink.hockeyapp.net/", "dedae71020c1c014120ef0153cb8457c");
    }
}