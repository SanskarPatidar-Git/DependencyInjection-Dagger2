package com.app.di.dagger.basic;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FactoryModule {

    /*
     This method will provide object of login model with runtime values
     the values are stored in component which will return this object using this module
     */
    @Provides
    LoginModel getLoginModel(@Named("username") String username , @Named("password") String password){
        return new LoginModel(username,password);
    }
}
