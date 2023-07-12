package com.app.di.dagger;

import android.app.Application;

//import com.app.di.dagger.basic.ApplicationComponent;
//import com.app.di.dagger.basic.DaggerApplicationComponent;


public class MyApplication extends Application {

    private static MyApplication application;
   // private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        //applicationComponent = DaggerApplicationComponent.create();
    }

    public static MyApplication getInstance(){
        return application;
    }

//    public ApplicationComponent getApplicationComponent(){
//        return applicationComponent;
//    }
}
