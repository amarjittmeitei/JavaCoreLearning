package com.exceptionHandling;

public class InChainMethods2 {
    public static void main(String[] args) {
        System.out.println("start");
        try{
            methodA(5,0);
            System.out.println(("mid1"));
        }

        catch (ArithmeticException e)
        {
            System.out.println("cannot divided by zero");
        }
    }

    static void methodA(int a, int b)
    {
        methodB(a,b);
        System.out.println("mid2");//unreadable line
    }

    static void methodB(int a, int b) {
        System.out.println(a/b);
        System.out.println("end"); //unreachable line
    }
}
