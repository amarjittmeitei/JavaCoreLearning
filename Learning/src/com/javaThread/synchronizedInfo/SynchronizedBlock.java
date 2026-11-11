package com.javaThread.synchronizedInfo;

public class SynchronizedBlock {

    public static void main(String[] args) throws Throwable{

        CounterB counter = new CounterB();

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

class CounterB{

    public int count = 0;

    public void increase(){

        //using internal lock of the object
        //lock belongs to the object
        //one object -> one lock
        synchronized (this){
            count++;
        }
    }
}
