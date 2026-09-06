package com.JavaStream;

/*
        Intermediate operations
            - filter()
            - map()
            - mapToInt()
            - mapToDouble()
            - flatMap()
            - sort()
            - limit()
            - skip()
            - distinct()
            - peek()

        Terminal operations
            - Collection result
                - toList()
                - collect()
            - Reducing
                - reduce()
                - sum()         |
                - max()         |
                - min()         |---> only works with primitive stream
                - average()     |     Use with object stream need to map to
                - count         |     primitive stream first!
            - Searching / matching
                - findFirst()
                - findAny() -> use in parallel stream!
                - anyMatch()
                - allMatch()
                - noneMatch()
            - Iteration
                - forEach()
                - forEachOrder() -> use in parallel stream!

*/


import java.util.*;
import java.util.List;
import java.util.List.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethod {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>(List.of(1,34,4,11,13,4));

        // ----------Intermediate Methods------------
        System.out.println("\n----------Intermediate Methods------------");
        //filter()
        System.out.println("\nUsing filter x -> x>10");
        iList.stream()
                .filter(x -> x > 10)
                .forEach(System.out::println);

        //map()
        System.out.println("\nUsing map x -> x *2");
        iList.stream()
                .map(x -> x*2)
                .forEach(System.out::println);

        //flatMap -> use for multi dimensional collection
        System.out.println("\nUsing flatMap");
        List<List<Integer>> mList = List.of(List.of(1,2),List.of(3,4));
        mList.stream()
                .flatMap(x -> x.stream())
                .map(x -> x*2)
                .forEach(System.out::println);

        //sort()
        System.out.println("\n Sorted the iLiat.stream");
        iList.stream()
                .sorted()
                .forEach(System.out::println);

        //distinct() -> return the distinct values
        System.out.println("\n Distinct values of iList");
        iList.stream()
                .distinct()
                .forEach(System.out::println);

        //limit() use with infinite stream
        System.out.println("\nLimiting a infinite stream iteration at 10");
        Stream.iterate(1,x -> x+1)
                .limit(10) // stoping the iteration at 10
                .forEach(System.out::println);

        //skip(x) - skip the first x elements
        System.out.println("\nSkipping the first 3 elements from iList");
        iList.stream()
                .skip(3) // skipping the first 3 elements
                .forEach(System.out::println);

        //peek() - use to inspect the stream in between the intermediate operations
        //       - mostly used for debugging not used in production
        System.out.println("Peeking in between: ");
        iList.stream()
                .filter(x -> x>8)
                .peek(x -> System.out.println("peek value: " + x))
                .map(x -> x*x)
                .forEach(x -> System.out.println("final value: " + x));


        // ----------Terminal Methods------------
        System.out.println("\n----------Terminal Methods------------");

        //forEach() it iterate
        System.out.println("\nfor each iteration: ");
        iList.stream().forEach(System.out::println);

        //toList -> it return immutable list
        System.out.println("\nUsing toList: ");
        List<Integer> ansList = iList.stream()
                .map(x -> x+5)
                .toList();
        System.out.println(iList);

        //collect() -> take Collector object as arguments
        //it returns mutable output
        System.out.println("\nUsing collect method: ");
        List<Integer> ansList2 = iList.stream()
                .map(x -> x+1)
                .collect(Collectors.toList());
        System.out.println(ansList2);

        //reduce() -> consume stream elements to single value
        System.out.println("\nUsing reduce method: ");
        Optional<Integer> sum = iList.stream()
                .reduce((a,b) -> a+b);
        System.out.println(sum.get());

        //overload: reduce() -> return int
        int sum1 = iList.stream()
                .reduce(0,(a,b) -> a+b);
        System.out.println("Overloaded reduce() sum1: " + sum1);
        int mult = iList.stream()
                .reduce(1, (a,b) -> a*b);
        System.out.println("Overloaded reduce() mult: " + mult);

        //count() -> count the total element
        long num = iList.stream().count();
        System.out.println("\ncount(): " + num);

        //findFirst() -> it use short circuiting
        Optional<Integer> first = iList.stream().findFirst();
        //Optional class is introduced to handle error that may
        //occur due to the empty input
        System.out.println("\nfindFirst(): " + first.get());
        //findAny() is same as findFirst, it works with parallel stream

        //anyMatch() -> if any match find return true
        boolean anyCheck = iList.stream()
                .filter(x -> x>5)
                .anyMatch(x -> x%2 == 0);
        System.out.println("\nanyCheck: " + anyCheck);

        //allMatch() -> if all elements match return true
        boolean allCheck = iList.stream()
                .filter(x -> x>5)
                .allMatch(x -> x%2 == 0);
        System.out.println("\nallCheck: " + allCheck);

        //noneMatch() -> if any match is not found, return true
        boolean noneCheck = iList.stream()
                .filter(x -> x>5)
                .noneMatch(x -> x%2 == 0);
        System.out.println("\nnoneCheck: " + noneCheck);

        //sum(), average(), min(), max(), count() works only with primitive
        //stream. Object stream needs to me map to primitive stream to use these methods
        int priSum = iList.stream()
                .mapToInt(x -> x)
                .sum();
        System.out.println("\npriSum: " + priSum);

        //primitive optional
        System.out.println("\nprimitive optional: ");
        OptionalInt priMax = iList.stream()
                .mapToInt(x -> x).max();
        System.out.println("priMax: " + priMax.getAsInt());

        OptionalDouble priAvg = iList.stream()
                .mapToInt(x -> x).average();
        System.out.println("priAvg: " + priAvg.getAsDouble());

        /*
            COLLECTORS CLASS
            Collectors' method return Collector object

            Collectors is inside java.util.stream.Collectors

            Basic method (in Collections)
                - toList()
                - toSet()
                - toMap()
                - groupingBy()
                - partitionBy()
                - joining()
        */
        System.out.println("\nCollections class");
        List<Integer> cList = iList.stream()
                .collect(Collectors.toList());
        System.out.println("cList: " + iList);

        Set<Integer> sList = iList.stream()
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("sList: " + sList);

        Map<Integer,Integer> cMap = iList.stream()
                .distinct()
                .collect(Collectors.toMap(
                        x -> x.hashCode(),x -> x
                ));
        System.out.println("cMap: " + cMap);

        //groupingBy
        List<String> sList2 = new ArrayList<>(List.of("AA","BBB","CCCC","DD","EEE"));
        Map<Integer,List<String>> gcMap = sList2.stream()
                .collect(Collectors.groupingBy(x -> x.length()));
        System.out.println("(groupBy) gcMap: " + gcMap);

        //partitioningBy
        Map<Boolean,List<String>> pcMap = sList2.stream()
                .collect(Collectors.partitioningBy(x -> x.length()>3));
        System.out.println("(partitioningBy) pcMap: " + pcMap);

        //groupingBy use with mapping
        Map<Integer,List<String>> gmcMap = sList2.stream()
                .collect(Collectors.groupingBy(
                        x -> x.length(),
                        Collectors.mapping(
                                x -> x.toLowerCase(),
                                Collectors.toList()
                        )));
        System.out.println("(groupingBy with mapping)gmcMap: " + gmcMap);
    }
}
