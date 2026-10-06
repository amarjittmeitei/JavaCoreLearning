package com.exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
    mostly used with check exception
    For example,
        FileReader file = new FileReader("abc.txt") <- internally it throw an
    exception that is force to be handled otherwise there will compilation error.
    So, it needs to be handles at the spot or can be throws to handle by the
    upper stack upto main. Main can also throws that, but that not recommended as
    if main throws it, it will go to the console.
*/
public class ThrowsInfo {

    public static void main(String[] args) {
        try
        {
            ReadFile();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("the file tried to read is not found");
        }
    }

    private static void ReadFile() throws FileNotFoundException
    {
        FileReader file = new FileReader("abc.txt");
    }
}
