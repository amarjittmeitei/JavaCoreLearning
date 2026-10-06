package com.exceptionHandling;

/*
    to close an opened resource in try block, we use finally block
    But this is error-prone if we forget to close the resource

    By using try-with-resource, without finally block and manually closing
    the opened resource, try-catch block do by itself
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) {
        try(FileReader file = new FileReader("abc.txt"))
        {
            //Business logic
        }
        catch (Exception e)
        {
            System.out.println("cannot open the file");
        }
    }
}
