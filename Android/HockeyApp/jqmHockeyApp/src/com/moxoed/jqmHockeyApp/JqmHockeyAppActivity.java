package com.moxoed.jqmHockeyApp;

import com.phonegap.*;
import android.os.Bundle;
import net.hockeyapp.android.UpdateActivity;

public class JqmHockeyAppActivity extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        UpdateActivity.iconDrawableId = R.drawable.icon;
    }
}