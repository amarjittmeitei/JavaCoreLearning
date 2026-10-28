package com.javaThread.imptMethods;

public class YieldMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           for(int i = 0; i<=10; i++)
           {
               System.out.println("t1: " + i);
               //yield method -> "I am willing to my CPU time to other thread
               //with same priority"
               //But, getting or giving up CPU time is totally depend on the OS
               //java don't have any power the perform CPU scheduling
               //yield() is just a suggestion to OS, OS may take it or not
               //So, it is rarely used in production
               Thread.yield();
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<=10 ; i++)
                System.out.println("\tt2: " + i);
        });

        t1.start();
        t2.start();
    }
}
