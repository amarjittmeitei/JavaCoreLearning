package com.core.Loop;

public class Foreach {
    public static void main(String[] args) {

        int nums[] = {1,2,3,4,5};
        for(int i:nums)
        {
            System.out.println(i);
        }
        System.out.println();
        for(int i:nums)
        {
            System.out.println(i);
            i = 0; //this will not be effect
        }
        System.out.println();
        for(int i:nums)
        {
            i = 0; //this will be effect
            System.out.println(i);
        }
        System.out.println();
        String fruits[] = {"apple", "orange", "lemon", "pineapple"};
        //iteration variable type must be same with the type of the collection
        for(String i:fruits)
        {
            System.out.println(i);
        }

    }
}
