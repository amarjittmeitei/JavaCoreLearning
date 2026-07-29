package com.practice;

public class worksheet
{
    static void swap(Integer x, Integer y)
    {
        Integer temp = x;
        x = y;
        y = temp;
    }
    public static void main(String[] args) {
        Integer x = new Integer(5);
        Integer y = new Integer(5);

        System.out.println(x==y);
    }


}