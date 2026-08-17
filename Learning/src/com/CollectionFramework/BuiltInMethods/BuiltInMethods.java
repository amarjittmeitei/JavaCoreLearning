package com.CollectionFramework.BuiltInMethods;

import java.sql.SQLOutput;
import java.util.*;

public class BuiltInMethods {
    public static void main(String[] args) {
        //Constructors of HasgSet/LinkedHashSet

        //Default constructor
        Set<Integer>set = new HashSet<>();

        //initial capacity
        Set<Integer> set1 = new HashSet<>(100);

        //capacity, Load factor (default value is 0.75)
        Set<Integer> set2 = new HashSet<>(100,0.8f);

        //Using another collection
        Set<Integer> set3 = new HashSet<>(List.of(1,2,4,5));

        //most of all the methods on Collection interface are used in HashSet/LinkedHashSet


        //TREESET
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(80);
        treeSet.add(23);
        treeSet.add(10);
        treeSet.add(90);
        treeSet.add(50);
        System.out.println("treeSet : " + treeSet);

        //from SortedSet Interface ---> time complexity O(log n)
        //BST
        //left most node ---> smallest
        //right most node ---> largest
        System.out.println("treeSet.first() : " + treeSet.first()); // return the smalled value
        System.out.println("treeSet.last() : " + treeSet.last()); // return the largest value
        //headSet(i) ---> return all the elements less than i excluding i
        System.out.println("treeSet.headSet(80) : " + treeSet.headSet(80));
        //tailSet(i) ---> return all the elements greater than i including i
        System.out.println("treeSet.tailSet(80) : " + treeSet.tailSet(80));
        //subSet(i,j) ---> return [i,j) the keys between i and j, i is included and j is not included
        System.out.println("treeSet.subSet(23,80) : " + treeSet.subSet(23,80));

        //from NavigableSet interface
        //lower(i) ---> return the largest key lower than i or null
        System.out.println("treeSet.lower(80) : " + treeSet.lower(80));
        //floor(i) ---> return the largest key less than equal to i
        System.out.println("treeSet.Floor(80) : " + treeSet.floor(80));
        //higher(i) ---> return the smallest key greater than i or null
        System.out.println("treeSet.higher(23) : " + treeSet.higher(23));
        //celling(i) ---> return the smallest key greater or equal to i
        System.out.println("treeSet.celling(23) : " + treeSet.ceiling(23));
        //pollFirst() ---> return the smallest key and remove it
        System.out.println("treeSet.pollFirst()" + treeSet.pollFirst());
        System.out.println(treeSet);
        //pollLast() ---> return the largest key and remove it
        System.out.println("treeSet.pollLast() : " + treeSet.pollLast());
        System.out.println(treeSet);
        //descendingSet() ---> return the set in descending order
        System.out.println("treeSet.descendingSet() : " + treeSet.descendingSet());
        //descending iterator
        System.out.println("descending iterator");
        Iterator<Integer> it = treeSet.descendingIterator();
        while(it.hasNext()){
            System.out.println("\t"+ it.next());
        }
        //override: headSet(i,inclusiveFlag) ---> true = i include, false = i exclude
        System.out.println("treeSet.headSet(80,true) : " + treeSet.headSet(80,true));
        //override: tailSet(i,inclusiveFlag) ---> true = i include, false = i exclude
        System.out.println("treeSet.tailSet(80,false) : " + treeSet.tailSet(50,true));
        //override: subSet(fromElement, fromInclusive, toElement, toInclusive)
        //clear()
        treeSet.clear();
        System.out.println("treeSet.clear() : " + treeSet);


        //MAP - map does not implement the Collection interface
        System.out.println();
        Map<Integer,String> map = new HashMap<>();
        map.put(101,"Amarjit");
        map.put(102,"Panthoi");
        map.put(103,"Heirok");
        System.out.println("map : " + map);

        //size()
        System.out.println("map.size() : " + map.size());
        //isEmpty()
        System.out.println("map.isEmpty(0 : " + map.isEmpty());
        //containsKey(key)
        System.out.println("map.containsKey(101) : " + map.containsKey(101));
        //containsValue(value)
        System.out.println("map.containsValue(\"Thadoi\") : " + map.containsValue("Thadoi"));
        //get(key) ---> return the corresponding key or null
        System.out.println("map.get(102) : " + map.get(102));
        //put(key,value) ---> add element to the map and return null, if key is
        //already exist return the old value
        System.out.println("map.put(104,\"Moirangthem\") : " + map.put(104,"Moirangthem")); // return null
        //return Amarjit (old value)
        System.out.println("map.put(101,\"Amarjit meitei\" : " + map.put(101,"Amarjit Meitei"));
        //remove(key) ---> remove the element of corresponding key and return the value of the key
        System.out.println("map.remove(104) : " + map.remove(104));
        //putAll(map)
        Map<Integer,String> tempMap1 = new HashMap<>();
        tempMap1.put(201,"Moirangthem");
        map.putAll(tempMap1);
        //keySet() ---> return set of all keys
        Set<Integer>mapKey = map.keySet();
        System.out.println("mapKey : " + mapKey);
        //values() ---> return a Collection type
        Collection<String> stringCollection = map.values();
        System.out.println("stringCollection : " + stringCollection);
        //entrySet() ---> return a set of Entry<K,V> Entry is an interface inside Map
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        System.out.println("entrySet : " + entrySet);
        //getOrDefault(key,defaultValue) ---> return the corresponding value of the key
        //if the key is absent return the default value
        System.out.println("map.getOrDefault(105,\"Unknown\") : " + map.getOrDefault(105,"Unknown"));
        //putIfAbsent(key,value) ---> if the key value is absent put the value on the key
        map.putIfAbsent(101,"Name");
        System.out.println("putIfAbsebt(101,\"Name\" : " + map);
        //override: remove(key,value) ---> remove of the key and value match
        map.remove(201,"Moirangthem");
        map.remove(101,"Amarjit");
        System.out.println("map.remove(key,value) : " + map);
        //replace(key,value) ---> replace the value on the key only if the key exist
        map.replace(101,"Amarjit");
        //overload: replace(key,oldValue,newValue) ---> replace only when the old value
        //of the key is match
        map.replace(102,"NameOld","NameNew");//no replacement 102 is "Panthoi"
        System.out.println("map.replace() : " + map);
        //Map.of()
        Map<Integer,String> tempMap2 = Map.of(1,"name1",2,"name2",3,"name3");
        System.out.println("tempMap2 : " + tempMap2);
        //but here tempMap2 is immutable cause run time exception: ImmutableCollections
        //tempMap2.put(104,"Name4"); // uncomment this line to see the runtime exception
        map.clear();
        System.out.println("map.clear() : " + map);


        //TREEMAP
        System.out.println();
        TreeMap<Integer,String>treeMap = new TreeMap<>();
        treeMap.put(401,"Amarjit");
        treeMap.put(402,"Panthoi");
        treeMap.put(403,"Heirok");
        System.out.println("treeMap : " + treeMap);

        //firstKey()
        System.out.println("treeMap.firstKey() : " + treeMap.firstKey());
        //lastKey()
        System.out.println("treeMap.lastKey() : " + treeMap.lastKey());
        //firstEntry()
        System.out.println("treeMap.firstEntry() : " + treeMap.firstEntry());
        //lastEntry()
        System.out.println("treeMap.lastEntry() : " + treeMap.lastEntry());
        //headMap() ---> same as headSet() on treeSet
        System.out.println("treeMap.headMap(402) : " + treeMap.headMap(402));
        //tailMap() ---> same as tailSet() on treeSet
        System.out.println("treeMap.tailMap(402) : " + treeMap.tailMap(402));
        //subMap() ---> same as subSet() on treeSet
        System.out.println("treeMap.subMap(401,402) : " + treeMap.subMap(401,402));

        //methods from Navigable interface
        //lowerKey(key)
        System.out.println("treeMap.lowerKey(402) : " + treeMap.lowerKey(402));
        //higherKey(key)
        System.out.println("treeMap.higherKey(402) : " + treeMap.higherKey(402));
        //lowerEntry(key)
        System.out.println("treeMap.lowerEntry(402) : " + treeMap.lowerEntry(402));
        //higherEntry(key)
        System.out.println("treeMap.higherEntry(402) : " + treeMap.higherEntry(402));
        //treeMap.pollFirstEntry();
        //treeMap.pollLastEntry();
        //treeMap.descendingMap();
        //most of all the methods on TreeSet are also here with modified name





    }
}
