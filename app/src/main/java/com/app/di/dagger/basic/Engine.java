package com.app.di.dagger.basic;

import android.util.Log;

import javax.inject.Inject;

public class Engine {

    private static final String TAG = "Engine";

    /*
    Need engine object by dagger
    tell dagger to create engine object by its constructor.
     */
    @Inject
    public Engine(){

    }
    public void start(){
        Log.i(TAG, "start: Engine Started");
    }
}
