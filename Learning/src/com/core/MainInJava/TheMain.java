package com.core.MainInJava;

public class TheMain {
    public static void main(String[] args)
    {
        //the main method is not a reserve identifier in Java
        //JVM will only search for the main method with same signature

        //it can be used as a variable supporting the polymorphism property of OOP

        int main = 6;
        System.out.println("the main variable: " + main);

        main();
        main(7);
    }

    static void main()
    {
        System.out.println("This is from a main method with different signature");
    }

    static void main(int a)
    {
        System.out.println("This is also a main method with different signature: " + a);
    }
}
