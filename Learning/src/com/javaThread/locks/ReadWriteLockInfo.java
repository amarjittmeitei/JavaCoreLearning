package com.javaThread.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    HERE WE ARE GOING TO SOLVE READER-WRITER PROBLEM USING READWRITE LCOK.

    READWRITE LOCK
            - A resource can be read by multiple reader thread at the same time
        without any problem
            - But, the resource can not be safely read by multiple thread at the
        time.

        - Reading is non-destructive (Shared lock)
        - writing is destructive (Exclusive lock)
*/
public class ReadWriteLockInfo {
    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();

        Thread r1 = new Thread(readerWriter::reader);
        Thread r2 = new Thread(readerWriter::reader);
        Thread r3 = new Thread(readerWriter::reader);
        Thread r4 = new Thread(readerWriter::reader);
        Thread w1 = new Thread(() -> readerWriter.writer(1));
        Thread w2 = new Thread(() -> readerWriter.writer(2));
        Thread w3 = new Thread(() -> readerWriter.writer(3));
        Thread w4 = new Thread(() -> readerWriter.writer(4));

        //here reader threads will run at time same time even there are lock
        //if there is no writer thread currently running
        //While the writer threads are run on at a time
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        r1.start();
        r2.start();
        r3.start();
        r4.start();

    }

}

class ReaderWriter{

    private int item;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock rLock = readWriteLock.readLock();
    private Lock wLock = readWriteLock.writeLock();

    public void reader(){
        rLock.lock();
        try{
            Thread.sleep(1000);
            System.out.println("Reader read: " + item);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            rLock.unlock();
        }
    }

    public void writer(int i){
        wLock.lock();
        try{
            Thread.sleep(1000);
            item = i;
            System.out.println("Writer writes: " + item);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            wLock.unlock();
        }
    }
}
