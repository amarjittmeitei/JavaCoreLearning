package com.javaThread.synchronizedDemo;

public class SynchronizedMethod {

    public static void main(String[] args) throws Throwable{

        CounterA counter = new CounterA();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i<1000; i++)
                counter.increase();
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<1000; i++)
                counter.increase();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter.count: " + counter.count);
    }

}

class CounterA{

    public int count = 0;
    public synchronized void increase(){
        count++;
    }
}

