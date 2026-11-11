package com.javaThread.lockFreeConcurrency;
/*
    Like counter can do without using retry loop by using AtomicInteger
    instead of AtomicReference
*/

import java.util.concurrent.atomic.AtomicInteger;

public class LikeCounterOptimized {
    public static void main(String[] args) throws InterruptedException {
        Likes l = new Likes();

        Thread t1 = new Thread(l::doLike);
        Thread t2 = new Thread(l::doLike);
        Thread t3 = new Thread(l::doLike);
        Thread t4 = new Thread(l::doLike);
        Thread t5 = new Thread(l::doLike);
        Thread t6 = new Thread(l::doLike);
        Thread t7 = new Thread(l::doLike);
        Thread t8 = new Thread(l::doLike);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();

        System.out.println("Total likes: " + l.getLikeCount());
    }
}

class Likes{
    private AtomicInteger likeCount =
            new AtomicInteger(0);

    public void doLike(){
        //this atomic method do the increment and set it
        likeCount.incrementAndGet();
    }

    public int getLikeCount(){
        return likeCount.get();
    }
}
