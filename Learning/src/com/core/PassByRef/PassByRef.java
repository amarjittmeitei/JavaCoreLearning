package com.core.PassByRef;

//swaping two value using pass by reference
//by default in java, method always pass the parameter by value

public class PassByRef {

    int x;
    int y;


    public PassByRef(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static void swap1(PassByRef r) {
        int temp = r.x;
        r.x = r.y;
        r.y = temp;
    }

    static void swap2(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        //in java method only do pass by reference but the int x and int y here,
        //the x and y are store the reference address in the stack mem pointing
        //to its value store in the heap mem
        //So, the pass by reference works here
        PassByRef ob = new PassByRef(3, 4);
        System.out.println("values before swaping: x=" + ob.x + " y=" + ob.y);
        swap1(ob);
        System.out.println("values after swaping: x=" + ob.x + " y=" + ob.y);

        //if the x and y are local variable inside a method it the value
        //will be store in the stack memory and the x and y will no longer
        //store the reference address, it will store the real constant
        //for example
        System.out.println("\npass by value (the default)");
        int x = 3; // x store 3 in the stack mem not the address of 3
        int y = 4; // y store 4 in the stack mem not the address of 4
        System.out.println("values before swaping: x=" + x + " y=" + y);
        swap2(x, y);
        System.out.println("values after swaping: x=" + x + " y=" + y);

    }
}