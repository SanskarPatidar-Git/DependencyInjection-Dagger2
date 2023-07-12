package com.app.di.dagger.basic;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/*
This module will provide the object of that classes which implement a interface Shape
Shape required object either of circle or square.
 */
@Module(includes = {ShapeModule.ShapeModuleBinds.class})
public class ShapeModule {

    //3 @Modules and @Provides.
    @Named("circle")
    @Provides
    Shape getCircle(){
        return new Circle();
    }

    @Named("square")
    @Provides
    Shape getSquare(){
        return new Square();
    }

    @RectangleQualifier // 4 .Instead of Named it will match by qualifier
    @Provides
    Shape getRectangle(){
        return new Rectangle();
    }

    @Module
    public interface ShapeModuleBinds{

        @Binds
        abstract Shape getTriangle(Triangle triangle);
    /* 5 . Binds
    In above methods we are giving object because dagger can not create it by calling constructor
    but in Triangle the dagger can create it by calling constructor
    so dagger will create object and return it.

    it is also defined it interface because provides and binds are not used in a single class
    either create another module or create a interface in module and include that module
    in @Module().
     */
    }

}

/* 4.
Here , the dagger will return object of that class which implement Shape
but we are providing two object which will return shape
So, dagger will give duplicate binding error because it don't understand which object should i provide
either circle or square

In this case we use @Named which work as key which will be matched by dagger
the key which will be passed when object is needed will be synced here and according to it specific
object will be returned by module.

Ex - void task(@Named("circle") Shape shape){}
when the object is needed dagger understand that circle object is requried so it will pass circle object.
 */
