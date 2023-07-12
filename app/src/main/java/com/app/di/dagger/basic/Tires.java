package com.app.di.dagger.basic;

public class Tires {

    /*
    We didn't create a constructor so dagger will not create a object with its constructor
    so the object of Tires will be get by modules.
     */
    public void initTire(){
        System.out.println("============ TIRE INITIALIZED ========= ");
    }
}
