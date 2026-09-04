package com.JavaStream;

/*

    STREAM
    A stream is a tool for processing a sequence of data through a chain of operation.

    Stream pipeline architecture:
    Source ---> Intermediate operation ---> Terminal operation

    list = [1,2,3,5]
    list.stream()          ---> source
        .filter(x -> x>10) ---> intermediate operation
        .map(x -> x*2)     ---> intermediate operation
        .toList()          ---> Terminal operation

    * if there is no terminal operation => No stream execution
    This is called lazy loading / lazy evaluation:
        Until there is a terminal operation there will be no execution of Java
    stream. This help the short-circuiting. Break the process if the required result
    is obtained. This improved the optimization of the stream

    Primitive Stream:
        1. IntStream
        2. LongStream
        3. DoubleStream

                                   Base Stream
                                        |
       ------------------------------------------------------------------
      |                   |                     |                       |
    Stream            IntStream             LongStream              DoubleStream
   (Object)

    Object -> Primitive
        Stream<Integer> s = list.stream();
        IntStream s2 = s.mapToInt();

    Primitive -> Object
        IntStream s = IntStream.of(1,2,3);
        Stream s2 = s.boxed();

    Primitive -> Primitive
        IntStream s = IntStream.of(1,2,3);
        LongStream s2 = s.mapToLong(x -> x);
        DoubleStream s3 = s.mapToDouble(x -> x);


*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamInfo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        Stream<Integer> s = list.stream();
        s = s.filter(x -> x>3); //4,5,6,7
        s = s.map( x -> x*x); //16,25,36,49
        s.forEach(System.out::println);


    }
}
