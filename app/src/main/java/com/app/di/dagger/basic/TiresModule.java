package com.app.di.dagger.basic;

import dagger.Module;
import dagger.Provides;

@Module
public class TiresModule {

    /*
    This method will provide a object of tires which will used by dagger.
     */
    @Provides
    Tires getTires(){
        return new Tires();
    }
}
