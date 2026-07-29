package com.moreoop.Inheritance;

/*

    "super" is the reference of superClass object (like "this" is the reference of
    the object of class itself.

    "super" is used to
        - call the super class constructor
        - access the super class variable and method by the subclass

 */

class ParentClass
{
    int a;
    int b;
    int i;

    ParentClass()
    {
        this.i = -1;
    }
    ParentClass(int i, int b, int a) {
        this.i = i;
        this.b = b;
        this.a = a;
    }

    ParentClass(ParentClass obj)
    {
        this.a = obj.a;
        this.b = obj.b;
        this.i = obj.i;
    }
}

class ChildClass extends ParentClass
{
    int x;
    int y;
    int i;

    ChildClass()
    {
        //this super call the default constructor of the parent class
        super();
        this.i = -1;
    }

    ChildClass(int x, int y, int i)
    {
        this.x = x;
        this.y = y;
        this.i = i;
        //here, "super" is used to access the super class member
        super.a = x+1;
        super.b = y+1;
        super.i = i+1;
    }


    ChildClass(int i, int b, int a, int x, int i1, int y) {
        //here super is used  to call the parent constructor;
        super(i, b, a);
        this.x = x;
        this.i = i1;
        this.y = y;
    }

    ChildClass(ChildClass obj)
    {
        //here obj of the Child class is pass a parameter of the super
        super(obj);
        this.x = obj.x;
        this.y = obj.y;
        this.i = obj.i;
    }

    public void cal()
    {
        //here can be used to access the member of the parent class
        //in case if there are some member with common name in the child and parent classes
        int temp = this.i + super.i;
        System.out.println("the sum of i's (from the child class): " + temp);
    }
}


public class SuperDemo {

    public static void main(String[] args) {
        ChildClass obj1 = new ChildClass(1,2,3,4,5,6);
        ChildClass obj2 = new ChildClass(obj1);
        obj2.cal();
        ChildClass obj3 = new ChildClass();
        obj3.cal();

    }
}
