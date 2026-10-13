package com.javaThread;

public class ThreadLifecycle {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        Thread t1 = new Thread(() -> {
                System.out.println("My thread name: " + Thread.currentThread().getName());
                System.out.println(mainThread.getName()+" state: "+ mainThread.getState());
        });
        //t1 at NEW state
        System.out.println(t1.getName()+" : "+t1.getState());
        t1.start();
        //t1 at RUNNABLE or TERMINATED stated (indeterministic)
        System.out.println(t1.getName()+" : "+t1.getState());

        //intentionally blocking the main thread to make
        //sure t1 thread complete its task
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Here the t1 state will be TERMINATED
        System.out.println(t1.getName()+" : "+t1.getState());



    }

}
