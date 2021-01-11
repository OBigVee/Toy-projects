package com.example.musicplayer;

import android.content.Context;


// this class runs before the mainActivity starts running

public class Application extends android.app.Application {
   public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
