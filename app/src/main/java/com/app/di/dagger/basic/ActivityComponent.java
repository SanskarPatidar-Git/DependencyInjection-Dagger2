package com.app.di.dagger.basic;

import com.app.di.MainActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;


@Singleton
@Subcomponent(modules = {ShapeModule.class , TiresModule.class})
public interface ActivityComponent {

    ExampleSubComponent getExampleSubComponent();
    void inject(MainActivity activity);
}
