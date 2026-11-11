package com.javaThread.commonProblems;

//Race condition problem due to unhandled share resource and critical section
//also Atomicity problem due to non-atomic critical section

public class RaceConditionDemo{
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(()->{
            for(int i = 1; i<=1000; i++)
                c.increaseCount();
        });

        Thread t2 = new Thread(()-> {
            for(int i = 1; i<=1000; i++)
                c.increaseCount();
        });

        //what we expect from here is that t1 increase the count 1000 times
        //and also t2 increase the count 1000 times
        //So, the after finished running the both thread count will be
        //equal to 2000
        t1.start();
        t2.start();

        //let the program wait till both t1 and t2 end its execution
        t1.join();
        t2.join();

        //after t1 and t2 threads are terminated
        System.out.println("The value of count: " + c.count);
        //here c.count may equal to 2000 or less.

    }
}

class Counter{
    public int count = 0; //shared resource
    public void increaseCount(){ //this method is critical section
        count ++; //shared resource
    }
}