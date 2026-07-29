package com.core.Method;

public class MethodInfo {

    //there are four type of methode in java
    //  1. No input, No output
    void method1() //no parameter here -> no input
    {
        System.out.println("method1");
        // no return -> no output
    }

    //  2. Has input, no output
    void methode2(int a)
    {
        System.out.println("Methodt2: " + a);
        //no return -> no output
    }

    //3. No input, has output
    int method3() // no parameter -> no input
    {
        System.out.println("Method3");
        return 0;
    }

    //Has input, has output
    int method(int a)
    {
        System.out.println("Method4: " + a);
        return 1;
    }

    //CHAINING OF FUNCTION
    //when one method call another method and the another call another inside it
    //for example
    void chain1()
    {
        chain2();
        System.out.println("Hello chain1\n");
    }

    void chain2()
    {
        chain3();
        System.out.println("Hello chain2");
    }

    void chain3()
    {
        //last method of the chain
        System.out.println("Chain3: the lass method of the chain");
    }
    public static void main(String[] args) {
        MethodInfo ob = new MethodInfo();
        ob.chain1();

    }
}
