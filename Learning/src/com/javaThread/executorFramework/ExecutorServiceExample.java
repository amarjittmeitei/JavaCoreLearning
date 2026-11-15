package com.javaThread.executorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //for execute(Runnable r)
        for(int i = 0; i<5; i++){
            int taskId = i;
            executorService.execute(()->{
                System.out.println("Task " + taskId + " is performed by " +
                Thread.currentThread().getName());
            });
        }
        executorService.shutdown();

        //for submit(Callable c)
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for(int i = 0; i<5; i++){
            int taskId = i;
            Future<Integer> f =  executorService1.submit(() -> taskId);
            try{
                System.out.println(f.get());
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        executorService1.shutdown();

    }
}
