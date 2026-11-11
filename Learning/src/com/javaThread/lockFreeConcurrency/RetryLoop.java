package com.javaThread.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReference;

/*
    RETRY LOOP
        A retry loop (CAS loop in lock-free programming) is a pattern
        where a thread repeatedly attempts an operation until it succeeds
        or hits a specific stopping condition.

    HERE, PERFORMING LIKE COUNTER USING ATOMIC REFERENCE FOR BETTER UNDERSTANDING
*/

public class RetryLoop {
    public static void main(String[] args) throws InterruptedException {
        LikeCounter l = new LikeCounter();

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

        System.out.println("Total likes: " + l.getLikes());

    }
}

class LikeCounter{

    private AtomicReference<Integer> likes =
            new AtomicReference<>(0);

    public void doLike(){
        Integer currentLike;
        Integer updatedLike;

        //retry loop
        while(true){
            currentLike = likes.get();
            updatedLike = currentLike+1;
            if(likes.compareAndSet(currentLike,updatedLike)){
                //if the thread reach here mean the value in likes is still
                //equal to the currentLike. So, the likes update to updatedLike
                //which is added one to the currentLike
                //so the task is successful, retry loop can exit now
                return;
            }
            //if thread reach here mean the current value in likes is not
            //equal to the value in currentLike mean some other thread
            //interrupted the thread and the value of likes is updated so our
            //updatedLike value is no longer valid. So, retry the task.
            //The retry loop will continue till the task completed.
        }

    }

    public int getLikes(){
        return likes.get();
    }
}