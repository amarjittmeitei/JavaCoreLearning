package com.javaThread.lockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReference;

/*
    ATOMIC VARIABLE
        An atomic variable is a special type of variable that allow to program
        Lock-free, thread safe operation on a single variable without using the
        synchronized keyword and other locks. It uses CAS (Check-and-set)
        hardware level cpu instruction like CMPXCG lock in x86 cpu.

        There are four Atomic variable
            - AtomicInteger
            - AtomicLong
            - AtomicBoolean
            - AtomicReference

        HERE, SEAT BOOKING PROBLEM IS SOLVING BY USING ATOMIC REFERENCE
*/
public class AtomicVariableInfo {
    public static void main(String[] args) throws InterruptedException {
        SeatBooking seatBooking = new SeatBooking();

        Thread t1 = new Thread(() -> {
            if(seatBooking.bookSeat("Thoi")){
                System.out.println(seatBooking.seat.get());
            }
        });
        Thread t2 = new Thread(() -> {
            if(seatBooking.bookSeat("Amarjit")){
                System.out.println(seatBooking.seat.get());
            }
        });
        Thread t3 = new Thread(() -> {
            if(seatBooking.bookSeat("Rexgona")){
                System.out.println(seatBooking.seat.get());
            }
        });
        Thread t4 = new Thread(() -> {
            if(seatBooking.bookSeat("Sunanda")){
                System.out.println(seatBooking.seat.get());
            }
        });
        Thread t5 = new Thread(() -> {
            if(seatBooking.bookSeat("Thoungamba")){
                System.out.println(seatBooking.seat.get());
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class SeatBooking{

    public AtomicReference<String> seat =
            new AtomicReference<>("EMPTY");

    public boolean bookSeat(String name){
//        String currentName = seat.get();
//        if(!currentName.equals("EMPTY")){
//            return false;
//        }
        return seat.compareAndSet("EMPTY",name);

    }

}
