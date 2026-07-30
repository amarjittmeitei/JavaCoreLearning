package com.moreoop.NestedClass;

/*

    Use cases of static nested class
    1. As helper class of any outer class
    2. Builder design pattern
    3. When we want static method inside a nested class
    4. Request/responds DTO (spring boot framework)

*/

public class StaticNested {

    static int i = 5;
    static private int j = 6;
    int k;

    public StaticNested() {
        this.k = 7;
    }


    //static nested class can be access without creating outer class object
    //OUTERCLASS.INNERCLASS OB = NEW OUTERCLASS.INNERCLASS();
    //in our case
    //StaticNested.Inner1 ob = new StaticNested.Inner1();
    static class Inner1
    {
        public Inner1() {
        }

        //it can access the outer member directly
        void display1()
        {
            System.out.println("Outer static data member: " + i);
            //can be access even the static member is private
            System.out.println("Outer private static data member: " + j);
        }

        //as static class is a static member
        //for non-static members the reference of the outer class is needed
        //via function parameter or constructor
        void display2(StaticNested ob)
        {
            System.out.println("Outer non-static member(via function parameter): "
                    + ob.k);
        }

        //using constructor
        StaticNested ob;
        Inner1(StaticNested ob)
        {
            this.ob = ob;
        }

        void display3()
        {
            System.out.println("Outer non-static member(via constructor): "
                    + ob.k);
        }


    }

}
