package com.javaThread.executorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                3,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );

        for(int i = 0; i<5; i++){
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is performed by "+
                        Thread.currentThread().getName());
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            });
        }

        executor.shutdown();



    }
}
