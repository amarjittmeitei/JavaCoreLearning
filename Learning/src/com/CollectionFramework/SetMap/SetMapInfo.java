package com.CollectionFramework.SetMap;
/*
    Simply start using the Set and Map
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
        System.out.println("mp.get(103) : " + mp.get(103));
        System.out.println("mp.containsKey(101) : " + mp.containsKey(101));




    }
}
