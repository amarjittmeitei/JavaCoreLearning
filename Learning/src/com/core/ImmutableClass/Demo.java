package com.core.ImmutableClass;

/*

    IMMUTABLE CLASS
    An immutable class in Java is a class whose instances cannot
    be modified after they are created. Once an object is constructed,
    its internal state and data remain completely frozen for its entire lifetime.

    Rules for an immutable class
        1. Mark the class as final
        2. Marks all the variables as private and final
        3. No setter method
        4. Defensive copy in constructor and getter (if non-primitive object is there
            and the class of the object is mutable)
 */

final class ImmutableClass
{
    //all the fields are set as private final
    private final int i;
    private final String name;
    private final OtherClass otherClass;

    /*

    Here shallow copy is done inside the construtor so dont do this

    public ImmutableClass(int i, String name, OtherClass otherClass) {
        this.i = i;
        this.name = name;
        this.otherClass = otherClass; <- Shallow copying to this.otherClass
    }

    */

    //instead of the above constructor
    //here, constructor using deep copy
    public ImmutableClass(int i, String name, OtherClass otherClass) {
        this.i = i;
        this.name = name;
        //deep copying the otherClass object to this.otherClass
        this.otherClass = new OtherClass(otherClass.name1, otherClass.name2);
    }

    //getters
    void getI()
    {
        System.out.println(this.i);
    }

    void getName()
    {
        System.out.println(this.name);
    }

    OtherClass getOtherClass()
    {
        //don't return the shallow copy of the this.otherClass like below
        //return otherClass;

        //instead return a deep copy of the this.otherClass
        return new OtherClass(this.otherClass.name1, this.otherClass.name2);
    }

    //no setter allowed

}

class OtherClass
{
    String name1;
    String name2;


    public OtherClass(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    void getName1()
    {
        System.out.println(this.name1);
    }
    void getName2()
    {
        System.out.println(this.name2);
    }
    void setName1(String i)
    {
        this.name1 = i;
    }
    void setName2(String i)
    {
        this.name2 = i;
    }

}



public class Demo {

    public static void main(String[] args) {
        OtherClass otherOb = new OtherClass("Moirangthem","Thadoi");
        ImmutableClass ob = new ImmutableClass(2,"Heirok",otherOb);

        ob.getI();
        ob.getName();
        ob.getOtherClass().getName1();
        ob.getOtherClass().getName2();

        //there is no way to change the fields of the object "ob" as there is
        //no setter in class ImmutableClass
        //But, OtherClass have setter, we can set the fields value
        //via otherOb.setName1() or otherOb,setName2()
        //but this modification will not reflect to ob.getOtherClass() as it
        //only return a deep copy of the object
        otherOb.setName2("Other name");
        ob.getOtherClass().getName2();


    }
}
