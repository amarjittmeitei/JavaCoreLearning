package com.CollectionFramework.QueueInfo;

/*


                     ITERABLE
                        |
     |-----LIST------COLLECTION
     |      |           |
     |  LINKED LIST   QUEUE ---------------|
     |      |           |                  |
     |      |---------DEQUE                |
     |                  |                  |
    STACK           ARRAYDEQUE       PRIORITY QUEUE



    Deque: Double-ended queue (pronounced as "deck"). It is a data type that allows
           to add and remove item from both the front and rear. In java it is used
           to implement both queue and stack


                                QUEUE
        insert                  Remove                      inspect
        add(E e)                remove()                    element()   --->throw exception
        offer(E e)              poll()                      peek()      --->safer

                                DEQUE
        insert                  Remove                      inspect
        addFirst(E e)           removeFirst()               elementFirst()
        addLast(E e)            removeLast()                elementLast()
        offerFirst(E e)         pollFirst()                 peekFirst()  ---> safer
        offerLast(E e)          pollLast()                  peekLast()   ---> safer

        -> Stack use
            push(E e)   ---equivalents---->  offerFirst(E e)
            pop()       ---equivalents---->  pollFirst()
            peek()      ---equivalents---->  peek()

        -> Stack - LIFO , Queue - FIFO : (Behavioral contract), programmer should
           make sure not to use the methods that may break the rules of FIFO and LIFO.
           As ArrayDeque implements Collection interface, all the methods in Collection
           interface are allowed to use.

        -> Priority queue: Smallest element has the highest priority as it use min heap.
           It can also use max heap by modifying the constructor


    For queue
        Enqueue ---> offer(E e)
        Dequeue ---> poll()

    For stack
        push(E e) ---> offerFirst(E e)
        pop()     ---> pollFirst()

*/


import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class DequeInfo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        //enqueue
        queue.add(1); // this is not safe as it throw runtime exception
        queue.offer(2); // return false is can not add -> safer
        queue.offer(3);
        queue.offer(4);

        //front access
        //safer
        System.out.println("queue.seek() : " + queue.peek());// return null if not found
        //throw runtime exception
        System.out.println("queue.element() : " + queue.element());

        //dequeue
        queue.remove(); // throw runtime exception
        queue.poll(); // return null of failed -> safer



        //min heap default priority queue
        System.out.println("Min heap default PriorityQueue");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(20);
        pq.offer(30);
        pq.offer(40);
        //min element got the highest priority
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        //max heap priority queue
        System.out.println("Max heap PriorityQueue");
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> b-a);
        maxPq.offer(10);
        maxPq.offer(20);
        maxPq.offer(30);
        maxPq.offer(40);
        //max element got the highest priority
        System.out.println(maxPq.poll());
        System.out.println(maxPq.poll());
        System.out.println(maxPq.poll());
        System.out.println(maxPq.poll());


    }

}
