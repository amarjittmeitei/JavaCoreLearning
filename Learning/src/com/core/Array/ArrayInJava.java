package com.core.Array;

public class ArrayInJava {
    public static void main(String[] args) {
        //initialization/declearation of array
        int[] demo1;
        //int rollNo[]; //this is also true

        //definition
        demo1 = new int[3];
        //where 3 is the size of the array

        //Or it can be done in one line
        int[] price = new int[3];
        //here price store in stack mem and new int[3] store in heap mem
        //price point to the base address of the int[3] in the heap;

        //also we can
        int[] demo2 = {3,5,8};

        //setting values of array
        price[0] = 5;

        //or using loop
        for(int i=0; i<3; i++)
        {
            price[i] = i+5;
        }

        //fetching an element of array is called random access
        System.out.println("Random access of price array at index 1: " + price[1]);

        System.out.println("Printing using loop: ");
        //accessing the array using loop
        for(int i = 0; i<3; i++)
        {
            System.out.println(price[i]);
            //if accessing array out of its size
            //the indexOutOfBoundException will occur
            //e.g. if used like price[5] = 10; //size of the array is only 3;
        }

        //length of the array
        System.out.println("Size of the array: "+price.length);

        //2-dimensional array (also called array of arrays)
        System.out.println("\nMulti Dimensional array:");

        //initialization
        int[][] marks = new int[3][3];

        //row length of the array
        //marks.length;

        //column length of the array
        //marks[0].length;

        //setting values
        for(int i = 0; i<marks.length; i++)
        {
            for(int j=0; j<marks[0].length; j++)
            {
                marks[i][j] = i+j;
            }
        }



        //accessing the array
        for(int i = 0; i<marks.length; i++)
        {
            for(int j=0; j<marks[0].length; j++)
            {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }


        //when we say int marks[][] = new int[x][y]
        //the value of x is compulsury
        //the value of y is optional
        //we can write like
        //int marks[][] = new int[3][]; // this is also true

        //here it is a array of arrays means marks[0] have an array,
        //and we can separately assign on it
        marks[0] = new int[2];
        marks[1] = new int[3];
        marks[2] = new int[4];

        //more than 2 dimension of an array is allowed up to 255 limited by jvm
        int[][][] demo3 = new int[3][3][3];

    }
}
