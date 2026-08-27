package com.CollectionFramework.ComparableInfo;

/*
        COMPARABLE INTERFACE
        It is a functional interface, which mean it have only one method
        compareTo()

        interface Comparable <T> {
            int compareTo(T other);
        }

        a.compareTo(b) return:
            1. (-ve) means a<b
            2. (+ve) means a>b
            3. 0 mean a == b

        - rules:
            if a.compareTo(b) == 0, then b.comapareTo(b) should also be
            equal to 0.


*/

import com.core.ImmutableClass.ImmutableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Demo1
{
    String name;
    int num;


    public Demo1(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

class Demo2 implements Comparable<Demo2>
{
    String name;
    int num;

    public Demo2(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public int compareTo(Demo2 o) {
        return this.num - o.num;
        //and can add more complex comparison rules
    }
}



public class ComparableInfo {
    public static void main(String[] args) {

        //for the class Demo we cannot compare there object
        //as it does not implement the interface functional Comparable
        List<Demo1> demo1 = new ArrayList<>();
        demo1.add(new Demo1("Amarjit", 4));
        demo1.add(new Demo1("Moirangthem", 8));
        //Collections.sort(demo1); //Compilation err

        //but for Demo2 class their object can be compared as it
        //implements the functional interface Comparable
        List<Demo2> demo2 = new ArrayList<>();
        demo2.add(new Demo2("Amarjit", 8));
        demo2.add(new Demo2("Moirangthem", 9));
        Collections.sort(demo2);
        for(Demo2 ob : demo2)
        {
            System.out.println(ob.name + " , " + ob.num);
        }
    }
}
