package com.javaThread.locks;

/*
    Conditional interface replace the old wait(), notify() and notifyAll() method
    own by the Object class.

    Modern alternatives provided by Conditional Interface
        - await() (in replace of wait())
        - signal() (in replace of notify())
        - signalAll() (in replace of notifyAll())

    HERE, SOLVING THE PRODUCER-CONSUMER PROBLEM USING REENTRANT LOCK AND
    CONDITIONAL INTERFACE
*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalInterfaceInfo {
    public static void main(String[] args) {
        Box box = new Box();

        Thread p = new Thread(() -> {
            for(int i = 0; i<10; i++){
                box.producer(i);
            }
        });

        Thread c = new Thread(() -> {
           for(int i = 0; i<10; i++){
               box.consumer();
           }
        });

        p.start();
        c.start();
    }
}

class Box{

    private Integer item = null;
    private Boolean flag = false;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(int value){
        lock.lock();
        try{
            while(flag){
                condition.await();
            }
            item = value;
            flag = true;
            System.out.println("Producer produced: " + item);
            condition.signal();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try{
            while (!flag){
                condition.await();
            }
            System.out.println("Consumer consumed: " + item);
            item = null;
            flag = false;
            condition.signal();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            lock.unlock();
        }
    }

}
