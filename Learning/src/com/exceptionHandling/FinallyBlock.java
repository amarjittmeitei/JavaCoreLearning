package com.exceptionHandling;

public class FinallyBlock {
    public static void main(String[] args) {
        System.out.println("start");

        try{
            int a = 5;
            int b = 0;
            System.out.println(a/b);

            //if exception is there the following code is unreachable
            System.out.println("mid");

            //so put the code in finally block
        }
        //multiple catch block are allowed
        catch (ArithmeticException e)
        {
            System.out.println("cannot divided by zero");
        }
        finally {
            //this block is always run even if the exception is
            //not handled by any catch block
            System.out.println("This line always run: " );

            //  this block is used:
            //      1. for cleanup code
            //      2. to close opened resources
            //      3, for logging
        }
        System.out.println("end");
    }
}
