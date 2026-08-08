package com.generics;

/*

    Invariant: A type relationship where neither a subtype nor a supertype can be
               substituted for the generics type. Java generics are invariant by default.
    Covariant: A type relationship where a subtype can be used in the place of its
               supertype. In java (? extends T) represent covariant.
    Counter variant: A type relationship where a supertype can be used where a subtype
                     is expected. In java (? super T) represents counter variant.

    Some problem without wildcard:
           Generics is invariant means
           lets say Dog IS-A Animal relationship is there
           but Demo<Dog> IS-A Demo<Animal> relationship is not there
           Generics break the parent child relationship.

    WILDCARD:
    Represented by ? question mark is used for an unknown type in generics
*/

import java.util.ArrayList;
import java.util.List;

class Parent
{
    void parentDo1()
    {
        System.out.println("Parent: parentDo1()");
    }

    void parentDo2()
    {
        System.out.println("Parent: parentDo2()");
    }
}

class Child extends Parent
{
    void childDo()
    {
        System.out.println("Child: childDo()");
    }
}


public class Wildcard {

    public static void main(String[] args) {
        //Taking List<> as an example for generic class
        //generics is invariant
        Child child= new Child();
        Parent parent = child; //IS-A relationship
        parent.parentDo1();
        //but in generics
        List<Child> childList = new ArrayList<>();
        //List<Parent> = childList; //no IS-A relationship -> compilation err

        //Here wildcard <?> is used
        List<?> list = childList; // no err


        List<Parent> p1 = new ArrayList<>();
        List<Child> c1 = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        p1.add(new Parent());
        p1.add(new Parent());
        c1.add(new Child());
        c1.add(new Child());
        objList.add(new Object());
        objList.add(new Object());

        //calling the normal method with generic type parameter
        genericParaMethod(p1); // this is legal
        //genericMethod(c1); // compilation error here generics is invariant


        //calling the method with wildcard generic parameter
        wildcardParaMethod(p1);


        //calling the method with upper bounded generic parameter
        upperBoundedWildCardPareMethod(p1);
        //as the generic extends Parent class the subclasses of Parent class
        //are also allowed
        upperBoundedWildCardPareMethod(c1);
        //but subclass of Parent are not allowed
        //upperBoundedWildCardPareMethod(objList); //<- this is not allowed


        //calling the method with lower bound class as parameter
        lowerBoundedWildcardParaMethod(p1);
        for(Parent i : p1)
        {
            System.out.println(i);
        }
        //as the generic extends Parent class the super classes of Parent class
        //are also allowed;
        lowerBoundedWildcardParaMethod(objList);
        for(Object i : objList)
        {
            System.out.println(i);
        }
        //but the subclass is not allowed
        //lowerBoundedWildcardParaMethod(c1); //<- this is not allowed
    }

    static void genericParaMethod(List<Parent> p)
    {
        //this is INVARIANT
        System.out.println("\ngenericParaMethod(): ");
        p.add(new Parent());// can write to Parent
        p.add(new Child()); //can write to Child
        System.out.println("the list: ");
        for(Parent i : p)
        {
            System.out.println("\t"+i.getClass().getName());
        }
        Parent x = p.get(0); // can be read
        //but the problem when the method is called only the Parent list is accepted
        //child list will be not accepted as generic break the IS-A relationship
    }

    static void wildcardParaMethod(List<?> x)
    {
        System.out.println("\nwildcardParaMethod: ");
        //But the wildcard is very limited
        //here the list cannot write and read is only possible on Object class object
        Object ob = x.get(0);
        //So, only method inside the object can be used.
        System.out.println(ob.getClass().getName());
        //No method for class on the argument can be used
    }

    static void upperBoundedWildCardPareMethod(List<? extends Parent> p)
    {
        //this is COVARIANT
        System.out.println("\nupperBoundedWildCardPareMethod: ");
        //now read is allowed also child class of Parent can be pass
        //on the method argument
        Parent x = p.get(0);
        x.parentDo1();
        x.parentDo2();
        //but write on the list is not still allowed.
        //because is the child class is passed on the method arguments/
        //then there will be a problem of assigning parent class object on the
        //child reference
        //for example
        //List<Child> ch = new ArrayList<>();
        //upperBoundWildcardMethod(child) <- this is allowed as generic is upper bounded
        //and inside this method if p.add(new Parent) <- here Parent object will
        //be pointed by the Child reference ch which is wrong. So, write is not allowed
        //in upper bounded generic method
    }

    static void lowerBoundedWildcardParaMethod(List<? super Parent> p)
    {
        //this is COUNTER VARIANT
        System.out.println("\nlowerBoundedWildcardParaMethod: ");
        //Here Parent class and its super class are allowed on the argument
        //Now write is allowed as all the argument will be super class of Parent
        //Super class reference can point to subclass object
        p.add(new Parent()); // parent class can be added
        p.add(new Child()); // child of parent class can be added as the reference
                            // variable will the super of parent.


    }
}

/*
    So,
    List<T> is invariant
    List<? extends T> is covariant
    List<? super T> is counter variant

    PECS rules:
        Producer Extends
        Consumer Super

*/