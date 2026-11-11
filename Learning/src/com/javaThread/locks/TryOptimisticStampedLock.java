package com.javaThread.locks;

/*
    tryOptimisticRead()
        this method in stamped lock will not block when an exclusive lock is
        acquired by writeLock(). It will try to read and writer writes in
        between we can do traditional pessimistic lock in fall over logic

    Here, solving the reader writer problem using tryOptimisticRead()
*/

/*
    In this code the optimistic lock failed most of the time is due to the
    internal slow process of System.out.println()
*/

import java.util.concurrent.locks.StampedLock;

public class TryOptimisticStampedLock {
    public static void main(String[] args) {
        ReaderWriterUsingOptimistic readerWriter = new ReaderWriterUsingOptimistic();
        Thread r1 = new Thread(readerWriter::reader);
        Thread r2 = new Thread(readerWriter::reader);
        Thread r3 = new Thread(readerWriter::reader);
        Thread r4 = new Thread(readerWriter::reader);
        Thread w1 = new Thread(() -> readerWriter.writer(1));
        Thread w2 = new Thread(() -> readerWriter.writer(2));
        Thread w3 = new Thread(() -> readerWriter.writer(3));
        Thread w4 = new Thread(() -> readerWriter.writer(4));

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        w1.start();
        w2.start();
        w3.start();
        w4.start();
    }
}

class ReaderWriterUsingOptimistic{
    StampedLock lock = new StampedLock();
    int item;


    public void reader(){
        Long stamp = lock.tryOptimisticRead();
        String threadName = Thread.currentThread().getName();
        //System.out.println(threadName+ ": Trying optimistic lock");
        int currentValue = item;

//        //mimicking some task
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException ex){
//            System.out.println(ex.getMessage());
//        }

        if(!lock.validate(stamp)){
            //means the optimistic lock failed
            //write have interface the reader in between
            //so we will do pessimistic lock instead
            //THIS IS -> FALL-OVER LOGIC
            threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": Optimistic lock failed!");
            stamp = lock.readLock();
            try{
                currentValue = item;
            }finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(threadName + ": reader read: " + currentValue);
    }

    public void writer(int i){
        Long stamp = lock.writeLock();
        String threadName = Thread.currentThread().getName();
        try{
            item = i;
            System.out.println(threadName + ": writer write: " + item);
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}


