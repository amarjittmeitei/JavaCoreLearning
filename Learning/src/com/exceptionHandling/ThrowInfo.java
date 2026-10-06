package com.exceptionHandling;

//it possible to intentionally throw exception if needed
public class ThrowInfo {
    public static void main(String[] args) {
        int inputAge = -2;

        try{
            checkVote(inputAge);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void checkVote(int age)
    {
        /*
        //exception can be throw inside a try block and catch
        //this approach is not recommended
        //catch the exception should the responsibility of the block that call the method
        try{
            if(age <=0)
                throw new IllegalArgumentException("Age cannot be zero or -ve");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        */

        //recommended approach
        //throw the exception
        //let the main or other method that call this method handle the exception
        if(age <= 0)
            throw new IllegalArgumentException("Age cannot be zero or -ve");
        if(age >= 18)
            System.out.println("Eligible for vote");
        else
            System.out.println("Not elegible for vote");
    }

}
