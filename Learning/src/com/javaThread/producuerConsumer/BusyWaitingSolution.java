package com.javaThread.producuerConsumer;
/*
    Here, I am tring to solve the problem using BUSY-WAITING while loop
        The problem of consuming null value and the problem of producer override
    the previous item value by producing another item before consumer consumed it
    is also solved.
        But, race condition is still there as the blocks are not synchronized. If
    context switch before producer print the item on console. Consumer may print
    before producer print it on the console.
*/


public class BusyWaitingSolution {
    public static void main(String[] args) {
        BoxB box = new BoxB();

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

class BoxB
{
    private volatile Integer item = null;
    private volatile Boolean flag = false;

    public void producer(int value){
        while(flag){
            //busy waiting
            //consume CPU time even during waiting as
            //it is continuously checking for flag
        }
        item = value;
        flag = true;
        System.out.println("Producer produced: " + item);
    }

    public void consumer(){
        while(!flag){
            //busy waiting
            //consume CPU time even during waiting as
            //it is continuously checking for flag
        }
        System.out.println("Consumer consumed: " + item);
        item = null;
        flag = false;
    }
}
