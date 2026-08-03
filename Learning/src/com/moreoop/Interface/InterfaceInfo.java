package com.moreoop.Interface;

/*
    INTERFACE
    An interface in Java is a reference type or a blueprint of a
    class that specifies what a class must do, but not how it does it.
    It is a core mechanism used to achieve total abstraction, loose
    coupling, and multiple inheritance.

    Syntax:
        interface InterfaceName
        {
            data_type field1 = {value};
            data_type field2 = {value};

            return_type methodName1();
            return_type methodName1();
            ...
            ...
        }
        -> methods inside an interface have no definition.
        -> the access modifier of all the methods in an interfaces are public abstract
           by default.
        -> After java 8 default methods are allowed definition inside the interface
        -> After java 9 private methods are allowed.
        -> fields are public static final by default. Private fields are not allowed.

        Internally interface is also a class with ACC_Interface tag
        class InterfaceName
        {
            ACC_Interface; //compiler tag to know its interface
        }

        * Functional Interface:
          A functional interface in Java is an interface that contains
          exactly one abstract method.
          This is used in functional programming -> lambda expression

          interface A
          {
            void method();
          }

        * Market Interface
          A marker interface (also known as a tagging interface)
          is an interface in Java that contains absolutely no methods or constants.
          Its sole purpose is to "deliver a message" to the Java Virtual
          Machine (JVM) or a compiler that the implementing class possesses a
          specific characteristic or capability.

          interface A
          {
          }


        After Java 9 Interface is must like abstract class
        But, the difference between Interface and abstract class:
            Interface
            Example:
                interface Runnable
                interface Walkable
                interface Payable

            1. Its contract, Role, Functionality based
               Like class CreditCard implement Payable
               here CreditCard is implementing the functionality Payable

            2. Interface is CAN-DO relationship
               like CreditCard can pay

            3. Normal fields are not allowed in interface even "int a;" is there
               internally its "public static final int a;".

            4. Constructors are not allowed inside an interface.

            5. Multiple inheritance can be simulated to class by using interface

            6. Multiple inheritance is allowed among the interfaces

            6. Methods in interfaces can be either private or public(which is
               implement with "default" keyword).


            Abstract Class
            Example:
                abstract class Animal
                abstract class Car

            1. It is the families of similar class
               Like class Dog extends Animal
               here the Dog is included in the families of Animal

            2. Abstract class is IS-A relationship
               like Dog IS AN animal

            3. Normal fields member are allowed in abstract class

            4. Constructors are allowed inside an abstract class

            5. Multiple inheritance cannot simulate to class
               with abstract class.

            6. Direct Multiple inheritance of classed is not allowed on abstract class.

            6. Methods inside the abstract class can have any access modifier
               public, private, or protected.



*/

//simple use of interface
interface Driveable
{
    void drive();
    //internally this method is public abstract.
    //public abstract void drive();
}

class Car implements Driveable
{
    //since the void drive was forced to public by the compiler
    //when we override, its need to be public
    //we cannot reduce the visibility
    @Override
    public void drive() {
        System.out.println("Car is driving...");
    }
}

class Bus implements Driveable
{
    //since the void drive was forced to public by the compiler
    //when we override, its need to be public
    //we cannot reduce the visibility
    @Override
    public void drive() {
        System.out.println("Bus is driving...");
    }
}



//fields are allowed in interface
//it is commonly used for storing group of constants in production codes
interface Constants
{
    double PI = 3.14;
    double GOLDEN_CON = 1.61;
    double EULER_NO =   2.72;

    //internally these fields are all public static final.
    //public static final double PI = 3.14;
    //public static final GOLDEN_CON = 1.61;
    //public static final EULER_NO =   2.72;

    //As they are static, they can be accessed with class.

}



//Interface can have method definition from java 8
interface Payable
{
    void pay();

    //default key word for method in interface is allowed after Java 8
    //inside the interface these are public
    default void failed()
    {
        System.out.println("Default method Payable.failed(): " + failedMsg());
    }

    //static methods are also allowed after java 8
    static void thanks()
    {
        System.out.println("Static method Payable.thanks(): Thank you");
    }

    //private methods are allowed after Java 9
    private String failedMsg()
    {
        return "Payment failed! (private failedMsg())";
    }

}

class Hdfc implements Payable
{
    @Override
    public void pay() {
        System.out.println("Payment done on HDFC bank");
    }
}



//interface can extend other one or more interfaces at a same time
//this is where java say multiple inheritance is allowed in interface
//But, interface cannot extend other class, interface cannot implement other
//interface(only extends is allowed).
interface Buyable extends Payable
{
    default void currency()
    {
        System.out.println("Default method Buyable.currency: Rupees");
    }
}

interface Sellable extends Payable
{
    default void currency()
    {
        System.out.println("Default method Sellable.currency: Rupees");
    }

}



//multiple inheritance in interface
interface Market extends Buyable, Sellable
{
    //here the DIAMOND PROBLEM comes
    //Market extends Buyable and Sellable
    //both have a default method called currency which have same signature
    //So, there is an ambiguity in Market interface which currency() method
    //should be used here.
    //Java handle this by throwing compilation error
    //And the ambiguous method/s need to override
    @Override
    default void currency()
    {
        System.out.println("Default method Market.currency: Rupees");
    }
}
//Now the Market interface can be implemented to other classes or interfaces
class VishalMart implements Market
{
    @Override
    public void pay() {
        System.out.println("VishalMart.pay: payment successfully");
    }
}



//Java resolution priority:
//Resolution priority determines how the compiler and the Java
//Virtual Machine (JVM) select the correct method or variable
//when multiple options are available.
class Vehicle
{
    public void failed()
    {
        System.out.println("Vehicle.failed: Failed to start engine");
    }
}

class Bike extends Vehicle implements Payable
{
    @Override
    public void pay() {
        System.out.println("Bike.pay: Payment successful.");
    }

    //class Vehicle have public void failed()
    //interface Payable also have default void failed();
    //the diamond problem ambiguity is not here as java give the priority
    //to methods of the extended class (Vehicle in our class) by Java
    //resolution priority rule
    public void engine()
    {
        //here the failed() method of Vehicle class will be called automatically
        failed();
    }

    //if the failed method of the Payable interface is needed to call
    //use "super" keyword -> InterfaceName.super.methodName();
    public void paymentIssue()
    {
        Payable.super.failed();
    }
}



public class InterfaceInfo {

    public static void main(String[] args) {

        //simple use of interface
        System.out.println("\nSimple use of interface:");
        //reference of the class itself
        Car audi = new Car();
        audi.drive();


        //interfaces apply polymorphism
        System.out.println("\nPolymorphism in interface:");
        //reference of the interface
        Driveable drive = new Car();
        drive.drive();
        Driveable drive2 = new Bus();
        drive2.drive();


        //accessing the fields of interface directly with class as they are
        //static by default
        System.out.println("\nInterface fields:");
        System.out.println(Constants.PI);
        System.out.println(Constants.EULER_NO);
        System.out.println(Constants.GOLDEN_CON);


        //method definition in interface
        System.out.println("\nMethod definition in interface:");
        Payable user1 = new Hdfc();
        //overridden method
        user1.pay();
        //default method called a private method inside it
        user1.failed();
        //static method
        Payable.thanks();


        //diamond problem
        //as method definition is allowed after Java 8, the diamond problem
        //needs to be handled. Java made rule for that.
        //the diamond problem ambiguity on currency() method of Market interface
        //is handled by overriding the method inside Market (overwise
        //compilation error will be there
        System.out.println("\nDiamond problem solution: ");
        Market thoubalVishal = new VishalMart();
        thoubalVishal.currency(); // no ambiguity on currency()
        thoubalVishal.pay();


        //Java resolution priority rule
        //Resolution priority determines how the compiler and the Java
        //Virtual Machine (JVM) select the correct method or variable
        //when multiple options are available.
        System.out.println("\nJava resolution priority:");
        Bike suzukiHayabusa = new Bike();
        suzukiHayabusa.engine();
        suzukiHayabusa.paymentIssue();
        suzukiHayabusa.pay();


    }

}
