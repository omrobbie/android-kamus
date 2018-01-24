/*
 * Created by omrobbie.
 * Copyright (c) 2018. All rights reserved.
 * Last modified 10/20/17 4:21 PM.
 */

package com.omrobbie.kamus;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by omrobbie on 20/10/2017.
 */

public class AppPreference {

    Context context;
    SharedPreferences prefs;

    public AppPreference(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;
    }

    public void setFirstRun(Boolean input) {
        SharedPreferences.Editor editor = prefs.edit();
        String key = context.getResources().getString(R.string.app_first_run);
        editor.putBoolean(key, input);
        editor.commit();
    }

    public Boolean getFirstRun() {
        String key = context.getResources().getString(R.string.app_first_run);
        return prefs.getBoolean(key, true);
    }
}
