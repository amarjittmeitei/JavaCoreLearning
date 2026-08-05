package com.core.JavaString;

/*

    STRING
    In Java, a String is an object that represents a sequence of characters
    (like letters, numbers, or symbols).
    Unlike other programming languages where strings are primitive data
    types (like int or char), a string in Java is a full-featured class
    defined in the java.lang package

    String can be declared in two from
        1. Literal
           String s = "hello";

           String object create by literal are store in special part of the heap
           called STRING POOL. When a string is declared in compile time
           the object store in the string pool.

           If your application uses the word "Admin" or "Success" thousands of times,
           Java only allocates memory for that string once in the pool. And all the
           variable will point to the same object instead of creating multiple object.
           String s1 = "world";
           String s2 = "world";
           s1 and s2 point to the same object in the string pool.

           In older java string pool is not a part of heap mem. It was in the
           different part of memory called PremGen.

        2. New operator
           String s = new String("Hello");

           Here, string is declare dynamically. And the object does not store in the
           string pool, instead it store in the general heap mem.

    The internal String class be like
    public final class String
    {
        private final byte[] values;
        //in older java: private final char[] values;
        private final byte coder;
        private final int hash;
    }

    -> byte[] value store the actual string in byte array
    -> coder store 0 or 1;
        0 for Latin1 when all the characters are ASCII. Read 1 byte from values
        for one character.
        1 for UTF16 when character outside the ASCII are included. Read 2 byte from
        values for onr character.

    Internal string optimization:
        1. String pool save memory by not creating duplicate object in string pool.
        2. use byte[] array for values after java 9 instead of char[] array.
        3. Caching the hash value in hash variable.

    Golden rule:
        Only compile time constants go to String pool automatically
        Runtime created String will go to heap

*/

public class StringInfo {


    public static void main(String[] args) {
        //String is immutable in java
        String s1 = "Hello"; //-> created inside the string pool
        s1.concat(" World"); // it does not concatenate to the s1
        String s2 = s1.concat(" World");// instead it returns new object
        System.out.println(s1); // here only "Hello" is print
        System.out.println(s2); // here "Hello World" is print
        //in the following line of code
        //s1 will point to new object "Amarjit". And the old object s1 = "Hello"
        // will be cleaned by garbage collector as no variable point on it
        s1 = "Amarjit"; // -> still in string pool as its literals
        s1 = s1+" Moirangthem"; // -> in heap mem as s1 + " String" is dynamic
        //here, new object "Amarjit Moirangthem" will be created and s1 point to the
        //new object the original "Amarjit" object will remain on the mem
        //if no other variable does not variable point on it, it will get cleaned up
        //by the garbage collector
        System.out.println(s1);


        //in literal initialization of string references of same strings
        //point to same object
        //these are compile time contains objects create inside the string pool
        String s3 = "Amarjit";
        String s4 = "Amarjit";
        String s5 = "Amar" + "jit";
        //this is true because s3 and s4 point to the same object
        System.out.println("s3 == s4 : " + (s3==s4)); //true
        System.out.println("s3 == s5 : " + (s3==s5)); //true

        //but initializing string with new operator will create two different objects
        //these are runtime created constants objects create inside the heap mem
        String s6 = new String("Moirangthem"); //this is in heap mem
        String s7 = new String("Moirangthem"); //this is in heap mem
        //here s5 and s6 do not point to same object
        System.out.println("s6 == s7 : " + (s6 == s7)); //false
        String s8 = "Moirangthem"; //this is in string pool
        //s6 in general heap mem and s8 in string pool so,
        System.out.println("s6 == s8 : " + (s6 == s8)); // false



    }

}
