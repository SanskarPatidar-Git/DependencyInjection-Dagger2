package com.app.di.dagger.basic;

import com.app.di.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // This component will provide a single instance of RootDatabase class.
@Component(modules = {TiresModule.class , ShapeModule.class})  //Defining modules that provides object which will returned by component.
public interface CarComponent {

    Car getCar(); // This method will return car object created by dagger.

    void inject(MainActivity mainActivity);

    //Optional for getting obj in method onCreate.
    RootDatabase getRootDatabase();
}
