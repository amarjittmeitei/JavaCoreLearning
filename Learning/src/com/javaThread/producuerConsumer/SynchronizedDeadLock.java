package com.javaThread.producuerConsumer;

/*
    To solve the race condition on the BusyWaitingSolution the program can go the
    deadlock instead of solving the race condition
*/
public class SynchronizedDeadLock {
    public static void main(String[] args) {
        BoxC box = new BoxC();

        Thread p = new Thread(() -> {
           for(int i = 0; i<20; i++){
               box.producer(i);
           }
        });

        Thread c = new Thread(() -> {
            for(int i = 0; i<20; i++){
                box.consumer();
            }
        });

        p.start();
        c.start();
    }
}

class BoxC{
    private volatile Integer item = null;
    private volatile  Boolean flag = false;

    public synchronized void producer(int value){
        while(flag){
            //busy-waiting
        }
        item = value;
        flag = true;
        System.out.println("Producer produced: " + item);
    }

    public synchronized void consumer(){
        while(!flag){
            //busy-waiting
        }
        System.out.println("Consumer consumed: " + item);
        item = null;
        flag = false;
    }
}

