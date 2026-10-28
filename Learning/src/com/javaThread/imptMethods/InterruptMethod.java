package com.javaThread.imptMethods;

public class InterruptMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           //isInterrupted() return the current interrupt flag value
           //interrupted() return the current interrupt flag value and set to false
           while(!Thread.currentThread().isInterrupted())
               System.out.println("t1: running");
        });
        System.out.println("Main thread here");
        t1.start();
        Thread.sleep(2000);

        //this method set the interrupt flag to true which is false by default
        //it is used to handle gracefully
        //  - We can have a thread run until a condition
        //  - Cancelling a long-running task
        //  - Used to stop a thread pool
        t1.interrupt();
    }
}
