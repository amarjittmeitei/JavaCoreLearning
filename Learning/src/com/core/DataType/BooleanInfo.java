package com.core.DataType;

public class BooleanInfo {

    public static void main(String[] args) {
        //boolean store true or false / 0 or 1;
        //this need only 1 bit to store in the memory
        //According to the official Javadoc there is not fix sized for boolean
        //different JVM decide the size of it
        //Hotspot (oracel open JDK) use 1 byte for a boolean variable
        //this is for the optimization of the CPU
        //as CPU instruction work on the byte level not bit by bit

        boolean i = true; // false
        //i = 1 is false unlike c++;
        System.out.println(i);


    }
}
