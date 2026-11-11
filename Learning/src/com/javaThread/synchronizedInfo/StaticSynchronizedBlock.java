package com.javaThread.synchronizedInfo;

public class StaticSynchronizedBlock {
    public static void main(String[] args) throws Throwable{

        Thread t1 = new Thread(()->{
           for(int i = 0; i<1000; i++)
               CounterC.increase();
        });

        Thread t2 = new Thread(()->{
           for(int i = 0; i<1000; i++)
               CounterC.increase();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("CounterC.count: " + CounterC.count);
    }
}

class CounterC{

    public static int count = 0;

    public static void increase()
    {
        //this lock is belong to the class
        //this is not the same lock that was belonged to the object
        //acquiring the lock belong to the class does not acquire the
        //internal lock of the object
        //the internal lock of the object can be still acquire by another
        //thread even this following synchronized block's lock is acquired
        synchronized (CounterC.class){
            count++;
        }
    }
}
