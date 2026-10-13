package com.javaThread;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
                System.out.println("Thread name: " + Thread.currentThread().getName()));

        // we can also use anonymous class
        Thread t2 = new Thread() {
            @Override
            public void run()
            {
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        };

        t1.start();
        t2.start();
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

}
