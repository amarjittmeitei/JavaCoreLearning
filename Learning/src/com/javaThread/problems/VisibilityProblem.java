package com.javaThread.problems;

/*
    Visibility problem
        t1 and t2 get the value of flag from ram and put it in their cache
        when t1 change to true, the value of flag in ram is also changed to true
        but t2 read value of flag from it cache which is false so the loop run
        infinitely even if the flag is true
*/


public class VisibilityProblem {

    static boolean flag = false;
    //Solution for this visibility problem is declare the shared resource volatile
    //static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           try
           {
               //let the t2 thread run for 2 seconds
               Thread.sleep(2000);
           }catch (Exception ex){}
           flag = true;
        });

        Thread t2 = new Thread(()->{
            while(!flag)
            {
                // System.out.println is synchronized for the visibility problem
                // will not happen so, to see the problem lets remove the
                // System.out.println and do nothing inside here
                //System.out.println("t1 running");
            }
            System.out.println("t2 finished");
        });

        t1.start();
        t2.start();
    }
}
