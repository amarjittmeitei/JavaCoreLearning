package com.exceptionHandling.customException;

public class CheckVote {
    public static void main(String[] args) {
        int inputAge = -6;
        try
        {
            checkVoteMethod(inputAge);
        }
        catch (InvalidAgeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void checkVoteMethod(int age)
    {
        if(age <= 0)
            throw new InvalidAgeException("Invalid age");
        else if (age<18)
            System.out.println("Not eligible for vote");
        else
            System.out.println("Eligible for vote");
    }


}
