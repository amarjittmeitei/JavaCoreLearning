package com.moreoop.Polymorphism;

/*

    there are two type of polymorphism
        1. Early binding / static binding / Compile time polymorphism
            -> these are the method overloading
        2. Late binding / dynamic binding / Run time polymorphism
            -> these are the method overriding


*/

class PolyDemo
{
    int x = 10;
    int y = 10;

    void msg()
    {
        System.out.println("polyDemo.msg: hello");
    }

    private void msg2()
    {
        System.out.println("polyDemo.msg2: hello");
    }
}

class polyDemo2 extends PolyDemo
{
    //these fields / variables can not be overridden
    int x = 10;
    int y = 10;

    //here the msg method is overriding
    //this is dynamic binding
    @Override
    void msg()
    {
        System.out.println("polyDemo2.msg: hello");
    }

    //here msg3 is overloaded
    //this is static binding
    void msg3()
    {
        System.out.println("polyDemo2.msg3: hello");
    }

    void msg3(String x)
    {
        System.out.println("polyDemo2.msg3: " + x);
    }

    //private method can not be overridden as they can not inherit
    //this following method will be considered as a new method
    void msg2()
    {
        System.out.println("polyDemo2.msg2: " + x);
    }
}


public class PolymorphismInfo {


}
