package com.moreoop.Polymorphism;

/*
    There are two type of polymorphism in Java
    1. Compile time polymorphism / Static polymorphism / early binding
    2. Run time polymorphism / Dynamic polymorphism / late binding
    3. Overriding and overloading does not apply to data members
*/

/*
    1. Compile time polymorphism
        this is executed by method overloading
        this is executed by constructor overloading
        this is done during the compile time
*/

/*
    2. Run time polymorphism
        this is executed by the method overriding
        this is done during the program run time
        java determine which method will be executed by dynamic method dispatch.

        NB: we cannot override a method which is final
*/

class Shape
{
    void perimeter(int a)
    {
        double temp = 2 * a * 3.14;
        System.out.println("Circumference: " +temp);
    }

    //here we have another method with same name perimeter
    //this is we call static polymorphism
    void perimeter(int a, int b)
    {
        int temp = 2 * (a+b);
        System.out.println("Perimeter : " +temp);
    }

    //here we have another method with same name perimeter
    //this is we call static polymorphism
    void perimeter(int a, int b, int c)
    {
        int temp = a + b + c;
        System.out.println("Perimeter : "+temp);
    }

    //here we have another method with same name perimeter
    //this is we call static polymorphism
    void info()
    {
        System.out.println("This is the information of the shape");
    }
}

class Circle extends Shape
{
    //here we override the info() method
    //we call it dynamic polymorphism
    void info()
    {
        System.out.println("This is a circle");
    }
}

class Rectangle extends Shape
{
    //here we override the info() method
    //we call it dynamic polymorphism
    void info()
    {
        System.out.println("This is a rectangle");
    }
}

class Triangle extends Shape
{
    //here we override the info() method
    //we call it dynamic polymorphism
    void info()
    {
        System.out.println("This is a triabgle");
    }
}


public class PolymorphismDemo {

    public static void main(String[] args) {

        Shape shape1 = new Shape();
        //the info method will call the parent info method
        shape1.info();

        Circle cir1 = new Circle();
        //here the java use DYNAMIC METHOD DISPATCH to determined which method to called
        cir1.info();
        cir1.perimeter(3);

        //use of upcasting
        Shape shape2 = new Triangle();
        shape2.info();
        shape2.perimeter(3,6,2);

    }

}
