package com.app.di.dagger.basic;

import javax.inject.Inject;

public class ExampleSubComponent {

    private Database database;

    @Inject
    public ExampleSubComponent(Database database){
        this.database = database;
    }

    public void initDatabaseAgain(){
        database.initDatabase();
    }
}
