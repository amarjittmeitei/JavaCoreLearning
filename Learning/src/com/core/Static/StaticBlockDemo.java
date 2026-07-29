package com.core.Static;

public class StaticBlockDemo {

    static int a = 4;
    static int b = 5;

    //this static block will run only when the first obj is created
    //that is when the class is first loaded
    //it will not run every time an obj is created
    static
    {
        System.out.println("Hello this is from the class StaticBlockDemo");
    }

    public static void main(String[] args) {
        //the static block will run this time as this the first obj
        //this is the first time that the class is loaded
        StaticBlockDemo ob1 = new StaticBlockDemo();

        //the static block will not run this time as this is not the first obj
        //the class is already loaded for the first time
        StaticBlockDemo ob2 = new StaticBlockDemo();

    }
}
