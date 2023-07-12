package com.app.di.dagger.basic;

import android.util.Log;

import javax.inject.Inject;

public class LoginModel {

    private static final String TAG = "LoginModel";
    private String name , password ;

    @Inject
    public LoginModel(String name , String password){
        this.name = name;
        this.password = password;
    }

    public void displayUserInfo(){
        Log.i(TAG, "displayUserInfo: Name = "+name+"  password = "+password);
    }
}
