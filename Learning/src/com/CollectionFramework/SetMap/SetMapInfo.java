package com.CollectionFramework.SetMap;
/*
    SET AND MAP

    Set
        -> Duplicate data are not allowed
        -> Constant time search operation O(1)
        -> Positional access are not there (no index based search)

    Map
        -> (Key, Value)
        -> Duplicate key are not allowed
        -> Constant time search operation O(1)
        -> Positional access are not there (no index based search)


    Internally java treat set as map with a dummy Object value
    Set<Integer> set = new HashSet<>();
        -internally-->
    Map<Integer,Object> map = new HashMap<>();

    set.add(2) ---> map.put(2,PRESENT);

    private static final Object PRESENT = new Object();

    (Set/Map ---> Map)
    class Node<K,V> {
        K key;
        V value;
        int hash;
        Node<K,V> next;
    }

    LinkedHashMap/LinkedHashSet : It keeps the order of element by using a
    doubly linked list
    class Node<K,V> {
        K key;
        V value;
        int hash;
        Node<K,V> next;
        Node<K,V> before, after;
    }

    TreeMap/TreeSet
        -> It use self-balancing BST (red and black tree)
        -> Keys are sorted.
        -> Can find largest and smallest keys
        -> Range query are allowed
        -> Works on lexicographical ordering (Dictionary ordering)
    class Node<K,V> {
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;
        Node<K,V> parent;
        boolean color; -> true/false red/black
    }

    HashMap/HashSet/LinkedHashMap/LinkedHashSet
        null are allowed in key for once
        null are allowed in value for multiple times

    TreeMap/TreeSet
        null are not allowed in either key or value


    * Mean to avoid Collision
        1. Linked List chaining ( java used this in collection framework)
        2. Open Addressing (Linear probing) (Java don't used this technique)

    * Load Factor
        In an array of set/map, Elements is the total elements on the set/map.
        And capacity is the size of the array number  of buckets.
        Load Factor = Elements/Capacity
        If Load Factor > 0.75 => Rehashing

    * Treeification
        If the linked list chaining of single bucket is greater than 8, then the
        linked list will be converted into a self-balancing BST (red and black tree)
        So, complexity will be reduced from O(n) to O(log n)

    * Hierarchy
        COLLECTION
            |
           SET------------------
            |                  |
         HASHSET               |
            |                  |
       LINKEDHASHSET        TREESET


           MAP------------------
            |                  |
         HASHMAP               |
            |                  |
       LINKEDHASHMAP        TREEMAP

 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMapInfo {
    public static void main(String[] args) {
        Set<String> str = new HashSet<>();
        str.add("Amarjit");
        str.add("Rexgona");
        str.add("Sunanda");
        System.out.println("str.contains(\"Amarjit\") : " + str.contains("Amarjit"));

        Map<Integer, String> mp = new HashMap<>();
        mp.put(101,"Amarjit");
        mp.put(102,"Thadoi");
        mp.put(103,"Panthoi");
        //mp.put(101,"moirangthem") // is not allowed, key should be unique
        System.out.println("mp.get(103) : " + mp.get(103));
        System.out.println("mp.containsKey(101) : " + mp.containsKey(101));

    }
}
