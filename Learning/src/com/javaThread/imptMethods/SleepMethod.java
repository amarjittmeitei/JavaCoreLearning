package com.javaThread.imptMethods;

public class SleepMethod {
    public static void main(String[] args){
        Thread t1 = new Thread(() -> {
            System.out.println("t1 started");
            System.out.println("wait for 2 sec");
            try {
                //keep this thread in TIMED_WAITING state for 2 sec
                Thread.sleep(2000); // 2000 milliseconds = 2 sec
            } catch (InterruptedException e) {}
            finally {
                System.out.println("t1 execution completed");
            }
        });
        System.out.println("main thread before t1.start()");
        t1.start();
        System.out.println("main thread after t1.start()");
    }
}
