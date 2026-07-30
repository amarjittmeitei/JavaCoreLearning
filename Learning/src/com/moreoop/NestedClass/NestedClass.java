package com.moreoop.NestedClass;


/*

    NESTED CLASS
    A nested class in Java is simply a class that is defined entirely
    inside the body of another class.

    class OuterClass
    {
        ...

        class InnerClass
        {
            ...
        }
    }

        Four types of nested class
        1. Static nested
        2. Inner nested
        3. Local nested
        4. Anonymous nested

    Needs of nested class:
        1. Local grouping: Grouping those class only meaningful and logically
            sense inside the class.
        2. Better access to outer class: The inner class can access the private
            member of the outer class

    - nested class can extend other classes
    - nested class can implement other interfaces
    - nested class can have static members
    - nested class can have private members


*/



public class NestedClass {

    public static void main(String[] args) {

        //1. static nested
        System.out.println("\n---Static nested class---");
        //In this case
        //  Outer class -> InnerNested
        //  Inner class -> Inner1
        StaticNested.Inner1 innerOb1 = new StaticNested.Inner1();
        innerOb1.display1();

        StaticNested ob = new StaticNested();
        innerOb1.display2(ob);

        StaticNested.Inner1 innerOb2 = new StaticNested.Inner1(ob);
        innerOb2.display3();


        //inner nested
        System.out.println("\n---Inner nested class---");
        //In our case
        //  Outer class -> InnerNested
        //  Inner class -> Inner2

        //to create an object of inner class (two ways to do it)
        //First way to do it (recommended);
        //  Step 1: first create an object of outer class
        InnerNested outerOb = new InnerNested();
        //  Step 2: using the outer object, the inner class object will be created
        InnerNested.Inner2 innerOb3 = outerOb.new Inner2();
        innerOb3.display1(1);

        //Second way to create the inner class object
        InnerNested.Inner2 innerOb4 = new InnerNested().new Inner2();
        innerOb4.display1(2);

        innerOb4.display2();
        innerOb4.display3();
        innerOb4.display4();

        //the static member of inner nested class objects will share the same
        //value regardless of the inner class is made by same or difference
        //outer class object
        innerOb3.setStatic(-1);
        innerOb4.setStatic(-2);

        InnerNested outerOb2 = new InnerNested();
        InnerNested.Inner2 innerOb5 = outerOb2.new Inner2();
        innerOb5.setStatic(-3);

        innerOb3.getStatic();
        innerOb4.getStatic();
        innerOb5.getStatic();

        //local nested
        System.out.println("\n---Local nested class---");
        LocalClass localOb1 = new LocalClass();
        localOb1.demo();

        //anonymous nested
        System.out.println("\n---Anonymous class---");
        AnonymousClass anonymousOb1 = new AnonymousClass();
        anonymousOb1.display();

        AnonymousClass anonymousClass = new AnonymousClass(){
            @Override
            void display()
            {
                System.out.println("Overridden method: Hello");
                helper();
            }

            //it can have other extra method
            //but cannot be access by the object
            //can be used as helper method
            void helper()
            {
                System.out.println("Helper method: Hello");
            }
        };

        anonymousClass.display();
    }
}
