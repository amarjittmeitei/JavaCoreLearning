package com.exceptionHandling;

public class InChainMethods1 {
    public static void main(String[] args) {
        System.out.println("start");
        methodA(5,0);
    }

    static void methodA(int a, int b)
    {
        methodB(a,b);
        System.out.println("mid1");
    }

    static void methodB(int a, int b)
    {
        try{
            System.out.println(a/b);
            System.out.println("mid2"); // unreadable line
        }
        catch (ArithmeticException e)
        {
            System.out.println("cannot divided by zero");
        }
        System.out.println("end");
    }
}
