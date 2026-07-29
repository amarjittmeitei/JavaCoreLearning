package com.moreoop.Inheritance;

/*
    About inheritance
    *Types of inheritance in java
        1. Single Inheritance
        2. Multilevel inheritance
        3. Hierarchical inheritance -> multiple child class have common parent class

        NB: Multiple inheritance is not allowed in java
        To implement multiple inheritance we use Interface.

        NB: Hybrid inheritance -> Single + multiple so, it is not support in java
        to implement this we use interface.
*/

class Parent
{
    //parent class is also called Super class

    int a;
    public Parent(int a) {
        super();
        this.a = a;

    }

    public void display()
    {
        System.out.println("This is from the parent class display() method");
    }

}

//here extends keyword is used to inherit class
//its like "class Child : public Parent" in c++
//java implicitly do public inheritance
//there is no option to change it in java unlike c++

class Child extends Parent
{
    //Child class is also call Subclass

    int b;

    public Child(int b) {
        //super keyword is used to call the constructure of the parent class or Super class
        super(b+1);
        this.b = b;
    }

    public void display2()
    {
        System.out.println("This is from the display2 method of the child class");
    }

}

//same class inherit itself is not allowed
//public class Child extends Child //-> this is not allowed

public class InheritanceBasic {

    public static void main(String[] args) {
        Child ch1 = new Child(3);
        ch1.display2();
        //here from the obj of the child class we can access the method of the parent class as well Parent.display();
        ch1.display();

        System.out.println(ch1.a);
        System.out.println(ch1.b);


        //we can create an object of Parent class with the reference of the child class
        //we call this UPCASTING
        Parent pr1 = new Child(3);
        pr1.display();
        //but we cannot call the method of the Child class with Parent object
        // pr1.display2(); //-> this is wrong
        // parent class does not have something call display2();

        //but we cannot create a Child class object with Parent class Reference
        //Child ch2 = new Parent(4); //-> this is wrong

    }
}
