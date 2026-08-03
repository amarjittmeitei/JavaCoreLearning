package com.moreoop.AbstractClass;

/*

    ABSTRACT CLASS
    An abstract class in Java is a restricted class that cannot
    be used to create objects directly. It acts as a blueprint or template
    for other classes, forcing them to inherit its structure.

    Syntax:
        abstract class ClassName
        {
            ...
        }

    Rules:
        1. Cannot use "new" keyword in abstract class like (new AbstractClassName)
           but, reference of abstract class can be used
        2. "abstract" keyword must be used before the "class" keyword of any abstract class.
        3. Abstract class can have both abstract and concrete method.
        4. If a class contain any abstract method, the class must be declared as abstract.
        5. An abstract class can have its constructor while its subclass need to
           call it with super. Run when the subclass object is created.
        6. An abstract class can have fields with all visibility type that inherit to
           its subclass
        7. Abstract class cannot be final

    Abstract Methods: These have no method body and end with a semicolon.Any concrete
    subclass must override and implement these methods. Abstract method cannot be private.

*/

abstract class AbstractClass
{
    //fields are allowed for all the visibility type
    private int i;
    protected int j;
    public int k;


    AbstractClass(int k) {
        this.k = k;
    }

    //abstract method cannot be private
    abstract void display();

    //concrete method are allowed
    void display2()
    {
        System.out.println("AbstractClass.display2(): Concrete method");
    }

    //final method and fields are allowed
    final int F = 8;
    final void display3()
    {
        System.out.println("AbstractClass.display3(): final method: " + this.F);
    }

    //static method are allowed, they can be called directly with the class name
    static void display4()
    {
        System.out.println("AbstractClass.display3(): Static method");
    }
}

public class AbstractClassInfo extends AbstractClass {

    public AbstractClassInfo(int i) {
        super(i);
    }

    //the abstract method needs to be overridden
    //otherwise there will be compilation
    @Override
    void display() {
        System.out.println("abstract void display overridden");
    }

    public static void main(String[] args) {
        //abstract class reference can be used
        AbstractClass ob = new AbstractClassInfo(4);
        ob.display();
        ob.display2();
        ob.display3();
        //static method can directly call with abstract class name(like normal class)
        AbstractClass.display4();
        System.out.println("Abstract class variable: "+ob.k);
    }
}
