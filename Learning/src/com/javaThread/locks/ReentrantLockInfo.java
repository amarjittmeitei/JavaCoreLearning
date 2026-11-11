package com.javaThread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Reentrant lock
        Unlike synchronized lock, reentrant lock have more control
        as it provide many methods to controls

    In any type of reentrant lock
        - A thread can acquire the same lock multiple time before unlocking
        it without blocking itself (self-deadlock)

    ReadWriteLock is also a reentrant lock so a thread can acquire multiple lock
    without blocking itself
*/

public class ReentrantLockInfo {
    public static void main(String[] args) {
        ResourseA resourse = new ResourseA();

        Thread t1 = new Thread(resourse::criticalSection);
        Thread t2 = new Thread(resourse::criticalSection);
        t1.start();
        t2.start();
    }

}

class ResourseA{
    Lock lock = new ReentrantLock();

    public void criticalSection(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + ": Started");
            //simulation some delay for task
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + ": ended");
        }finally {
            lock.unlock();
        }


    }
}
