package com.LambdaExpression.FunctionPackInfo;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/*

    There are four functional interface in the function package
        1. Function
        2. Consumer
        3. Supplier
        4. Predicate

    Function
        Take input ---transform---> give output
        interface Function <T,R> {
            R apply(T t);
        }

    Consumer
        Take input ----> No output
        interface Consumer <T> {
            void accept(T t);
        }

    Supply
        Take no input ---> Give output
        interface Supply<T> {
            T get(void);
        }

    Predicate
        Take input ---> Give boolean output
        interface Predicate<T> {
            boolean test(T t);
        }


    Primitive functional interface
        1. Function (primitive family)
            1.1 IntFunction (int -> <R>);
            1.2 LongFunction (long -> <R>);
            1.3 DoubleFunction (double -> <R>);

            1.4 ToIntFunction (<R> -> int)
            1.5 ToLongFunction (<R> -> long)
            1.6 ToDoubleFunction (<R> -> double)

        2. Consumer (primitive family)
            2.1 IntConsumer (int -> void)
            2.2 LongConsumer (long -> void)
            2.3 DoubleConsumer (double -> void)

            2.4 ObjectIntConsumer(T,int -> void)
            2.5 ObjectLongConsumer(T,long -> void)
            2.6 ObjectDoubleConsumer(T,double -> void)

        3. Supplier (primitive family)
            3.1 IntSupplier (void -> int)
            3.2 LongSupplier (void -> long)
            3.3 DoubleSupplier (void -> double)

        4. Predicate (primitive family)
            4.1 IntPredicate (int -> boolean)
            4.2 LongPredicate (long -> boolean)
            4.3 DoublePredicate (double -> boolean)

    Primitive Operation family:
        1. IntUnaryOperator (int -> int)
        2. LongUnaryOperator (long -> long)
        3. DoubleUnaryOperator (double -> double)
        4. IntBinaryOperator (int, int -> int)
        5. LongBinaryOperator (long, long -> long)
        6. DoubleBinaryOperator (double, double -> double)

    Function reference:
        Function reference operator -> (::)
        ClassName :: methodName

        Example: list.forEach(System.out::println)

        Types of function reference:
            1. Static method refence
                x -> Math.abs(x);
                        |
                (Math::abs)

            2. Instance method reference
                x -> System.out.println(x);
                        |
                (System.out::println)

            3. Constructor method reference
                Supplier<T> s = () -> new ArrayList<Integer>();
                List<Integer> list = s.get();
                        |
                Supplier<T> s = ArrayList::new
                List<Integer> list = s.get();

        Composition chaining:
            1. Function chaining
                1.1 andThen(Function) -> return Function
                1.2 compose(Function) -> return Function

            2. Predicate chaining:
                2.1 and(Predicate) -> return Predicate
                2.2 or(Predicate) -> return Predicate
                2.3 negate() -> return Predicate

            3. Consumer chaining:
                3.1 andThen(Consumer) -> return Consumer

        Variant of Functional interface
            1. Function <T,R>  ---> BiFunction<T,U,R> T and U are Input
            2. Consumer <T>    ---> BiConsumer<T,U>
            3. Supplier<T>     ---> X
            4. Predicate<T,U>  ---> BiPredicate<T,U> T and U are Input



*/

public class FunctionPackInfo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4));

        //Using Function interface
        System.out.println("\nUsing Function interface: ");
        Function<Integer,Integer> sqr = x -> x*x;
        System.out.println(sqr.apply(4));

        //Using Consumer interface
        System.out.println("\nUsing Consumer Interface: ");
        Consumer<Integer> display = x -> System.out.println("Consumer var: "+x);
        display.accept(6);

        //Using Supplier Interface
        System.out.println("\nUsing Supplier interface: ");
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        //Using predicate interface
        System.out.println("\nUsing Predicate interface: ");
        Predicate<Integer> even = x -> x%2 == 0;
        System.out.println("6 is even: " + even.test(6));

        //Method reference
        System.out.println("\nMethod reference: ");
        Function<Integer,Integer> absolute = Math::abs;
        System.out.println(absolute.apply(-6));

        //Chaining functional interface
        System.out.println("\nChaining functional interface");
        /*
            Mathematically,
                ans = {3(x+2)}

                f(x) = x+2
                g(x) = x*3

                ans = g(f(x))
        */
        System.out.println("Function interface chaining: ");
        Function<Integer,Integer> add2 = x -> x+2;
        Function<Integer,Integer> mul3 = x -> x*3;
        Function<Integer,Integer> ans = add2.andThen(mul3);
        System.out.println(ans.apply(5));

        //Compose is reverse of andThen
        Function<Integer,Integer> ans2 = mul3.compose(add2);
        System.out.println(ans2.apply(5)); // result will be same as ans

        System.out.println("Predicate interface chaining: ");
        Predicate<Integer> isEven = x -> x%2 == 0;
        Predicate<Integer> isGreater = x -> x>10;
        Predicate<Integer> ans3 = isEven.and(isGreater);
        System.out.println("34 is greater then 10 and even: " + ans3.test(34));
        System.out.println("35 is greater then 10 and even: " + ans3.test(35));

        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("35 is odd: " + isOdd.test(35));

        //Consumer chaining
        System.out.println("Consumer chaining: ");
        Consumer<String> upperCase = x -> System.out.println(x.toUpperCase());
        Consumer<String> printString = System.out::println;
        Consumer<String> result = printString.andThen(upperCase);
        result.accept("AmaRjiT");
    }
}
