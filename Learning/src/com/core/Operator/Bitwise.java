package com.core.Operator;

public class Bitwise {
    public static void main(String[] args)
    {
        int a = 6;
        int b;
        b = 0b11011 >> 3;
        String aa;
        String bb;

        System.out.println("\ncom.core.Operator.Bitwise NOT b = ~a : ");
        aa = Integer.toBinaryString(a);
        bb = Integer.toBinaryString(b);
        System.out.println("a (binary): " + aa);
        System.out.println("b (binary): " + bb);
        System.out.println("a (int): " + a);
        System.out.println("b (int): " + b);
    }
}
