package com.javaThread.withRunnableInterface;

public class MainClass {
    public static void main(String[] args) {
        RunnableThread r1 = new RunnableThread();
        Thread t1 = new Thread(r1);
        t1.start();
    }

}
