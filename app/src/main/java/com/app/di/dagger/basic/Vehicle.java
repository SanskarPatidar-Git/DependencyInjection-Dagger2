package com.app.di.dagger.basic;

import javax.inject.Inject;

public class Vehicle {

    @Inject
    public Vehicle(){

    }
    public void initVehicle(){
        System.out.println("============ VEHICLE INITIALIZED =========== ");
    }
}
