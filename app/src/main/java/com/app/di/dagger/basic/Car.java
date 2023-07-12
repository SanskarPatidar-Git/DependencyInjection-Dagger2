package com.app.di.dagger.basic;

import javax.inject.Inject;

public class Car {

    private static final String TAG = "Car";
    Engine engine;

    /*
    Need a car object by dagger we need to tell dagger that
    if you need to create a object of car you can create by calling its constructor.

    When calling its constructor we need to pass engine object also which will be created by dagger
    by using @Inject on Engine also.
    also create engine object by calling Engine constructor.
     */
    @Inject
    public Car(Engine engine){
        this.engine = engine;
    }

    public void startEngine(){
        engine.start();
    }
}
