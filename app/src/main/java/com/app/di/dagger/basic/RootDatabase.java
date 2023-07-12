package com.app.di.dagger.basic;

import javax.inject.Inject;
import javax.inject.Singleton;

/*
The object of this class is created only once and used all over.
We are generally using this singleton for instance of DB and others.
this object is used by CarComponent so we need to annot CarComponent as @Singleton.
 */
@Singleton
public class RootDatabase {

    @Inject
    public RootDatabase(){

    }
}
