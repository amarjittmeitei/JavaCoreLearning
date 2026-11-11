package com.javaThread.synchronizedInfo;

public class CustomLock {

    public static void main(String[] args) {
        Transaction transaction = new Transaction();

        Thread t1 = new Thread(transaction::methodA);
        Thread t2 = new Thread(transaction::methodB);

        t1.start();
        t2.start();
    }

}

class Transaction{

    final private Object lock1 = new Object(); //final keyword is not compulsory
    final private Object lock2 = new Object(); //final keyword is not compulsory

    public void methodA(){
        synchronized (lock1){
            System.out.println("[Transaction] methodA started");
            try {
                Thread.sleep(2000);
            }catch (Exception ex) {}

            System.out.println("[Transaction] methodB ended");
        }
    }

    public void methodB(){
        synchronized (lock2){
            System.out.println("[Transaction] methodB started");
            try {
                Thread.sleep(2000);
            }catch (Exception ex) {}
            System.out.println("[Transaction] methodB ended");
        }
    }
}
