package com.app.di.dagger.basic;

import javax.inject.Inject;

public interface Shape {
    void Shape();
}

class Square implements Shape{

    @Override
    public void Shape() {
        System.out.println("========== SHAPE - SQUARE ==========");
    }
}

class Circle implements Shape{

    @Override
    public void Shape() {
        System.out.println("========== SHAPE - CIRCLE ==========");
    }
}

class Rectangle implements Shape{

    @Override
    public void Shape() {
        System.out.println("========== SHAPE - RECTANGLE ==========");
    }
}

class Triangle implements Shape{

    @Inject
    public Triangle(){

    }

    @Override
    public void Shape() {
        System.out.println("========== SHAPE - TRIANGLE ==========");
    }
}
