package com.javaThread.imptMethods;

public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 thread started");
            try {
                System.out.println("=== Wait for 3 sec ===");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                System.out.println("t1 thread execution completed");
            }
        });
        System.out.println("Main thread started");
        t1.start();
        //the t1.join() method pause other thread until t1 die
        //this method throw and check exception InterruptedException
        t1.join();

        //Overloaded of join() method --> join(millis)
        //join(millis) will wait for maximum millis milliseconds to finish
        //its task, if not done in millis, it let the other thread
        //to continue execution

        //if the t1.join() is not there this following line will be executed
        //while t1 is waiting for the 3 sec sleep
        System.out.println("Main thread finish execution");
    }
}
