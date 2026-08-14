package com.CollectionFramework.IterableInfo;

//implementing the Iterable interface on our user defined class

import java.util.Iterator;

class NameContainer implements Iterable<String>{
    String[] values;

    public NameContainer(String[] values) {
        this.values = values;
    }

    @Override
    public Iterator<String> iterator() {
        return new NameContainerIterator();
    }

    class NameContainerIterator implements Iterator<String>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return (count < values.length);
        }

        @Override
        public String next() {
            return values[count++];
        }
    }
}

public class Implementation {
    public static void main(String[] args) {
        String[] str = {"Amarjit","Sunanda","Rexgona","Santosh","Tolen","Loushingba"};
        NameContainer names = new NameContainer(str);

        Iterator<String> it1 = names.iterator();
        while(it1.hasNext())
        {
            System.out.println(it1.next());
            //no modification is allowed here -> runtime exception
        }

        //also we can use for each loop only for those class which implement iterable
        Iterator<String> it2 = names.iterator();
        for(String c: names)
        {
            System.out.println(c);
            //no modification allowed here -> runtime exception
        }

    }


}
