package com.moreoop.ObjectClass;//overriding the toString method of class by default

//this class demonstrate the default toString of the class without overriding
class Demo1
{
    String name;
    int id;

    Demo1(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
}

//this class override the default toString method of the class
class Demo2
{
    String name;
    int id;

    Demo2(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String toString()
    {
        return name;
    }


}



public class ClsToString {

    public static void main(String[] args) {
        Demo1 ob11 = new Demo1("amarjit",1);
        Demo2 ob21 = new Demo2("moirangthem",2);

        //this call the default toString method
        System.out.println(ob11);
        //this call the override toString method on demo2
        System.out.println(ob21);
    }
}
