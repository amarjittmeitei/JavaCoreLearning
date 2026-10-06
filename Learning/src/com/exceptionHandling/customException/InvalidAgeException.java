package com.exceptionHandling.customException;

//public class InvalidAgeException extends Exception //<- Check exception
public class InvalidAgeException extends RuntimeException //<- Runtime exception
{
    public InvalidAgeException(String msg)
    {
        super(msg);
    }
}
