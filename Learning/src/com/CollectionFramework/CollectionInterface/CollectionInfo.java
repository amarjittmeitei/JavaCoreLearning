package com.CollectionFramework.CollectionInterface;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionInfo {
    public static void main(String[] args) {

        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);

        //int size()
        System.out.println("c.size() : "+c.size());

        //boolean isEmpty() -> can be use like size() == 0 but isEmpty() is optimized
        System.out.println("c.isEmpty() : "+c.isEmpty());//false;

        //boolean contains(Object o)
        System.out.println("c.contains(1) : "+c.contains(1));//true
        System.out.println("c.constains(5) : "+c.contains(5)); //false

        //iterate() return an object of iterator()

        //Object[] toArray()
        System.out.println("c.toArray():");
        Object[] obj = c.toArray();
        for(Object o : obj){
            System.out.println("\t"+o);
        }

        //overload: T[] toArray(T[] e) -> T[] e in parameter is just denotation not used
        System.out.println("(overload) c.toArray(): ");
        Integer[] arr = c.toArray(new Integer[0]);
        for(Integer i : arr){
            System.out.println("\t"+i);
        }

        //boolean add(E e) -> return the 1 for success 0 for failed
        System.out.println("c.add(5) : " + c.add(5));

        //boolean remove(Object obj)
        System.out.println("c.remove(1) : " + c.remove(1));
        System.out.println("c.remove(10) : " + c.remove(10));

        //boolean addAll(Collection<? extends T> c)
        System.out.println("c.addAll(List.of(6,7,8)) : " + c.addAll(List.of(6,7,8)));
        System.out.println(c);

        //boolean containsAll(Collection<?> c)
        System.out.println("c.containsAll(List.of(3,4,5)) : " + c.containsAll(List.of(3,4,5)));

        //boolean removeAll(Collection<?> c)
        System.out.println("c.removeAll(List.of(1,2) : " + c.removeAll(List.of(1,2)));
        System.out.println(c);

        //boolean retainAll(Collection<?> c)
        System.out.println("c.retainAll(List.of(4,6)) : " + c.retainAll(List.of(4,6)));
        System.out.println(c);

        //clear()
        c.clear();
        System.out.println("c.clear(): " + c);

    }
}
