package com.javaThread.producuerConsumer;

/*
                   ______
    PRODUCER ---> | box  | ---> CONSUMER
                   ------

    The producer consumer problems:
        1. Consumer tries to consume null value (consumer tries to consume before
            producer produce)
        2. Producer produce a value before consumer consume the previous value
            so, the previous will overside cause data lose.
*/

public class TheProblem {
    public static void main(String[] args) {

        BoxA box = new BoxA();

        Thread p = new Thread(() -> {
           for (int i = 0; i<20; i++){
               box.producer(i);
           }
        });

        Thread c = new Thread(() -> {
            for (int i = 0; i<20; i++){
                box.consumer();
            }
        });

        p.start();
        c.start();
    }
}

class BoxA {
    private volatile Integer item = null;
    private volatile Boolean flag = false;

    public void producer(int value) {
        item = value;
        flag = true;
        System.out.println("Producer produced: " + item);
    }

    public void consumer() {
        System.out.println("Consumer consumed: " + item);
        item = null;
        flag = false;
    }
}

