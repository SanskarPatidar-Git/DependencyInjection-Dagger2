package com.app.di;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.di.dagger.DashboardActivity;
import com.app.di.dagger.MyApplication;
//import com.app.di.dagger.basic.ActivityComponent;
//import com.app.di.dagger.basic.ApplicationComponent;
import com.app.di.dagger.basic.Car;

import com.app.di.dagger.basic.CarComponent;

//import com.app.di.dagger.basic.Database;
import com.app.di.dagger.basic.RectangleQualifier;
import com.app.di.dagger.basic.RootDatabase;
import com.app.di.dagger.basic.Shape;
import com.app.di.dagger.basic.Tires;
import com.app.di.dagger.basic.Vehicle;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    Car car; //Get object with constructor injection directly

    @Inject
    Vehicle vehicle;  //Get object with field injection

    @Inject
    Tires tires;

    @Named("circle")
    @Inject
    Shape shape;

    @RectangleQualifier
    @Inject
    Shape shapeQualifier;

    @Inject
    Shape shapeBinds;

    @Inject
    RootDatabase rootDatabase;

//    @Inject
//    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        /*
//         1. @Inject
//         Get simple Car object by dagger using constructor injection.
//         */
//
//        CarComponent carComponent = DaggerCarComponent.create();
//        car = carComponent.getCar();
//        car.startEngine();
//
//
//        /* 2. @Inject -> Field injection
//        If this class need lots of dependencies so we need to create multiple methods in component
//        and getting object of each class by calling method of component
//        instead of it we will use field injection.
//
//        we will pass activity to component by defining single method in component
//        and which class need object by dagger we annot that class with @Inject
//
//        Ex -  @Inject
//              Car car;
//
//              @Inject
//              Vehicle vehicle;
//
//              So get vehicle object with field injection.
//         */
//        carComponent.inject(this);
//        vehicle.initVehicle();
//        /*
//        Now if a class need multiple dependency pass only object of class to component
//        and annot the class with @Inject.
//         */
//
//
//
//        /*
//         3.
//         @Module and @Provides
//         If dagger is not unable to create a object with its constructor
//         then we need to tell the dagger that it will get object from module with contains method
//         which provide the object to dagger and dagger will use it when it is needed.
//
//         Ex -  when we are using third party library like RoomDatabase
//         we arent create object to room directly by calling its constructor
//
//         */
//        tires.initTire();
//        /*
//        ->Create a module for a particular class which will provides object
//        ->Define that module in component also
//        ->We are using field injection for tyre if not that define a method in component
//          which will return a Tires object.
//         */
//
//
//
//
//        /*
//        4. @Named and @Qualifier
//         This annotation is used for syncing the required objects.
//         Ex - if there is an interface which is implemented by two classes and we required the object from
//         a particular class using modules so how dagger will understand that which object is required.
//
//         -> Visit ShapeModule
//         */
//        shape.Shape(); // it will get circle object because we have annot @Named("circle") on Shape.
//        /*
//        Or you can use custom qualifier for syncing.
//        @Named also contain @Qualifier like @RectangleQualifier.
//
//        Copy the annotations of @Named and paste to our custom qualifier @RectangleQualifier.
//        Now the dagger will match the qualifier instead of Named.
//         */
//        shapeQualifier.Shape();
//        /*
//        You can also create same like for Circle and Square.
//         */
//
//
//
//
//        /*
//        5. @Binds
//        If you are providing any object from module so we are creating and telling to dagger to use it.
//        but when any object is required by module but the dagger can create itself using constructor
//        then the dagger will create it and return the object
//        Binds annot only on abstract method
//
//        Ex -> Triangle shape in Shape Module
//         */
//        shapeBinds.Shape();
//
//
//
//
//        /*
//        6. @Singleton
//        Singleton is used for creating only single instance and use it everywhere.
//        like @Named is associated with @Qualifier same @Singleton is associated with @Scope
//
//        to describe a single object of any class annot that class with @Singleton
//        and the component which provide the object of that class will also annot with @Singleton
//         */
//        System.out.println("====== OBJECT FOR FIRST ROOT-DATABASE -> "+rootDatabase);
//
//        RootDatabase rootDatabase1 = carComponent.getRootDatabase();
//        System.out.println("====== OBJECT FOR SECOND ROOT-DATABASE -> "+rootDatabase1);
//        /*
//        As you can see that we are creating two objects but the reference of both objects are same
//        both objects are same
//        Now if we need multiple times the objects it will return already created object.
//
//        But there is one problem-
//        it is singleton for activity wise but not by application wise
//        when you rotate your screen onCreate will called again and the objects will be another because it will
//        create again objects
//        The scope of singleton is decided by the component which will create it.
//        if you define Component object in Activity onCreate it will initialized again and create another objects
//        instead of it you can define Component in Application onCreate and use that component.
//
//        1. Define component in Application onCreate()
//         CarComponent carComponent = DaggerCarComponent.create();
//        2. access the component -> in Activity (MyApplication(getApplication)).carComponent
//        3. use component -> carComponent.getRootDatabase();
//
//        It will provide only single instance of class either on rotation change or other
//
//        Just like you create Custom Qualifier for @Named
//        create two annot for Singleton @ActivitySingleton -> the component scope will be in activity only
//                                       @ApplicationSingleton -> component will be in application
//        use this two annotation according to your requirement
//
//        Ex - @ApplicationSingleton
//         */
//        ApplicationComponent applicationComponent = ((MyApplication)getApplication()).getApplicationComponent();
//        Database database = applicationComponent.getDatabase();
//        System.out.println("======= SINGLETON APPLICATION 1 -> "+database);
//
//        Database database1 = applicationComponent.getDatabase();
//        System.out.println("======= SINGLETON APPLICATION 2 -> "+database1);
//        /*
//        After rotating screen you can check that the reference is same as earlier
//        it means after rotation the already created object is returned.
//        The scope of singleton decides on Component that where it is declared.
//        The component is initialized in Application onCreate.
//         */
//
//
//
//
//        /*
//        7. Factory or Component.Factory
//        When we are creating object on runtime with specific values we need a factory in component
//        which will hold the data and pass it to the object.
//        Ex -> creating login object with username and password which will get on runtime
//        to create an object of Login with this credential we need to store this data into component
//        So, factory is required to create object with dynamic values in runtime.
//
//
//         */
//
//        /* 8. @Component.Builder pattern
//        Same like factory old codes are using builder pattern
//        -> Component.Builder
//        -> Builder consist a build method which will return Component Ex- CarComponent build();
//        -> instead of single method in factory we have to declare multiple methods for multiple values which will return builder.
//        Ex- for username and password
//
//         @BindsInstance
//         Builder setUsername(@Named("username") String username); and so on for other attributs
//
//         -> pass the values like DaggerCarComponent.Builder.setUserName("dagger").build();
//         In builder it is optional to set values in above line but in factory create we have to pass argument
//         is mandatory.
//         */
//
//
//
//
//
//        /*
//        9. @SubComponent and SubComponent.Factory
//        When any component need dependency from another component like from application component
//        we are mentioning dependencies in component tag like modules
//        @Component(dependencies = {AppComponent.class} , modules = {})
//        getting appComponent from application and passing to factory of component.
//
//        Instead of it we are using subcomponent which will use all dependencies of AppComponent(another)
//        it will return the Component object which is declared as subComponent
//        appComponent.getComponent.create(); -> Like this
//
//         */
//        ActivityComponent activityComponent = ((MyApplication)getApplication()).getApplicationComponent().getActivityComponent();
//        activityComponent.inject(this);
//        database.initDatabase();





        /*
        Navigate to next activity in which we will implement the note app
        in which we will store the notes in room db and fetch the data from room and show in recycler view.
         */
        Button button = findViewById(R.id.implementationBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                finish();
            }
        });

    }
}