package com.javaThread.producuerConsumer;

/*
    Here, I am going to use wait(), notify(), notifyAll() to solve the
    problem effectively

    wait() -> it keep the thread in waiting pool

    notifyAll() -> wake up all threads from waiting pool
    notify() -> wake up a random thread from waiting pool

    notifyAll() is safer then notify() as in some case with larger number
    thread notify() can still put to program in deadlock in some case

    In this case, I can still safely use notify() as I work only with
    2 user thread sharing the critical section's shared resource

    But, I will use notifyAll().
*/

public class TheRealSolution {
    public static void main(String[] args) {
        BoxD box = new BoxD();

        Thread p = new Thread(() -> {
           for(int i = 0; i<20; i++){
               try{
                   box.produce(i);
               }catch (InterruptedException ex){
                   System.out.println(ex.getMessage());
               }
           }
        });

        Thread c = new Thread(() -> {
           for(int i = 0; i<20; i++){
               try{
                   box.consumer();
               }catch (InterruptedException ex){
                   System.out.println(ex.getMessage());
               }
           }
        });

        p.start();
        c.start();
    }
}

class BoxD{
    private volatile Integer item = null;
    private volatile Boolean flag = false;

    public synchronized void produce(int value) throws InterruptedException {
        //while there is a value in the box
        while(flag){
            //putting the thread in waiting pool
            //Here, flag is check with while loop not with if condition
            //This is because sometime thread in waiting pool wake up without
            //any notify or notify() due to internal OS activity
            //this condition is called SPURIOUS WAKEUP
            //to keep the thread back in the waiting pool while loop is used
            //this while loop is called GUARDED BLOCK
            wait();
        }
        item = value;
        flag = true;
        System.out.println("Producer produced: " + item);
        //item produced so, wake up all other thread in waiting pool
        notifyAll();
    }

    public synchronized void consumer() throws InterruptedException {
        //while there is not item in the box
        while(!flag){
            //same explanation as producer
            wait();
        }
        System.out.println("Consumer consumed: " + item);
        item = null;
        flag = false;
        //item consumed so, wake up all the threads in waiting pool
        notifyAll();
    }
}
