package com.javaThread.withRunnableInterface;

public class RunnableThread implements Runnable{
    @Override
    public void run()
    {
        System.out.println("Thread is running...");
    }

}
