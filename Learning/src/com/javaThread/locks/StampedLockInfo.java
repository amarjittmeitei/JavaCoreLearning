package com.javaThread.locks;
/*
    STAMPED LOCK
        It is not a reentrant lock it used a stamp of Long type to lock and
        unlock a lock.
        It can also work like reader writer lock but by using stamp and still not
        a reentrant lock

    As StampedLock is not a reentrant lock. So, the same thread calling a
    lock method a second time before unlocking is what causes it to block itself.
*/


import java.util.concurrent.locks.StampedLock;

public class StampedLockInfo {
    public static void main(String[] args) {
        ResourceB resource = new ResourceB();

        Thread t1 = new Thread(resource::criticalSection);
        Thread t2 = new Thread(resource::criticalSection);
        Thread t3 = new Thread(resource::criticalSection);

        t1.start();;
        t2.start();;
        t3.start();
    }
}

class ResourceB{
    StampedLock lock = new StampedLock();
    public void criticalSection(){
        Long stamp = lock.writeLock();
        try{
            System.out.println(Thread.currentThread().getName() + ": Started");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": ended");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            lock.unlock(stamp);
        }
    }
}
