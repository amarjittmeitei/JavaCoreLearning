package com.core.SingletonClass;

//singleton class is a class that can have only one obj of it
//here SingletonDemo class can have only one object/instence of it
//to do this first the constructor of the singleton class should be private
//so that any other cannot create an object of it
class SingletonDemo {

    public int id;
    private SingletonDemo()
    {

    }

    //but the in the class object can still create
    private static SingletonDemo obj;

    //now create a public method that return the object of the SingletonDemo class
    //make it static class so that it can be accessed without creating an object
    //as creating an object of this class is not possible outside the class
    public static SingletonDemo getObject()
    {
        if(obj == null)
            obj = new SingletonDemo();
        return obj;

    }
}

public class Singleton
{
    public static void main(String[] args) {
        SingletonDemo mainObject1;
        //as the getObject() method is static it can be call using the name of class
        mainObject1 = SingletonDemo.getObject();

        SingletonDemo mainObject2 = SingletonDemo.getObject();
        SingletonDemo mainObject3 = SingletonDemo.getObject();

        //here call this mainObject1, mainObject2, mainObject3 are all pointing to
        //the same object so,
        mainObject1.id = 4;
        System.out.println(mainObject2.id);
        System.out.println(mainObject3.id);

        //it is not possible to create a more than one object here
        //we called this singleton class

    }
}

