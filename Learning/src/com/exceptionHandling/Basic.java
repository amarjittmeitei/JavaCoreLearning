package com.exceptionHandling;

public class Basic {
    public static void main(String[] args) {
        System.out.println("start");

        try{
            int a = 5;
            int b = 0;
            System.out.println(a/b);

            //if exception is there the following code is unreachable
            System.out.println("mid");
        }
        //multiple catch block are allowed
        catch (ArithmeticException e)
        {
            System.out.println("cannot divided by zero");
        }
        System.out.println("end");
    }
}
