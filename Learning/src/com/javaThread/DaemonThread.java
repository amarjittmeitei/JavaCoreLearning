package com.javaThread;
/*
                                    THREAD
                                       |
            --------------------------------------------------------------
           |                                                              |
        User thread                                                    Daemon thread
                                                                    t1.setDaemon




    - Daemon thread is a background task running thread
    - It automatically terminate even its task not complete if all the user thread
        main thread are finish execution
    - Mean, the main thread will not wait for the demon thread to complete its
        execution.

    - Example: Garbage Collector
    - To make a thread demon thread -> t1.setDaemon(true)
*/
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           while(true)
               System.out.println("t1: running...");
        });

        //here the main thread will die instantly and there is no other user thread
        //t1 is also daemon thread so the t1 will not execute at all in
        //most of the time
        t1.setDaemon(true);
        //sleep() can be add here to stop the main thread from termination so that
        //the daemon thread t1 get some time to execute
        //sleep(1000);
        t1.start();
        return;
    }
}
