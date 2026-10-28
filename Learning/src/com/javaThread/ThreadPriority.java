package com.javaThread;

/*
    Java thread priority range from 1 (min) to 10 (max)

    Some pre-defined priority
        MIN_PRIORITY = 1
        NORM_PRIORITY = 5
        MAX_PRIORITY = 10

    But, its depend on the OS
        - OS may respect the priority
        - OS may not respect the priority
        - OS may totally ignore the priority
*/


public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i <= 10; i++)
                System.out.println("t1: " + i);
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++)
                System.out.println("\tt2: " + i);
        });

        t1.start();
        t2.start();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

    }
}
