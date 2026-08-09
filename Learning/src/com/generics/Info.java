package com.generics;

/*
            UPCASTING
            is the process of casting a child class (subclass) object
            to a parent class (superclass) reference type.
            No manual casting is required in upcasting.

            DOWNCASTING
            the process of casting a parent class (superclass) reference
            back to a child class (subclass) reference type.
            Manual casting is required in downcasting.
            It can crash the program at runtime with a ClassCastException
            if the underlying object is not actually an instance of the target subclass.

            Class Parent
            {
                ...
            }
            Class Child
            {
                ...
            }

            psvm
            {
                Parent pr = new Child() <- upcasting

                Child ch1 = (Child) new Parent; <- downcasting
                            or
                Parent pr1 = new Parent();
                Child ch2 = (Child) pr1; <- downcasting
                               ^
                   here manual casting is required
                Object obj = 50;
                String str = String(obj); -> no compilation error but it will
                                             throw ClassCastException in runtime
                                             (50 cannot be assigned to String str)
            }
*/

/*
    Limitation of using Object as Universal type
    1. Type information is lost
    2. Wrong object can be assigned
    3. Casting become necessary when reading
    4. Many error shift to runtime (ClassCastException)
*/

/*
    GENERICS
    It is a feature that allows to parameterize types.
    They enable us to define classes, interfaces, and methods where
    the type of data they operate on is specified as a parameter when
    we create or use them.

    Let's consider a class

    class Demo
    {
        int i;
        int j;
    }

    Creating generics

    class Demo <T> //type parameter, it can be any non-primitive type
    {
        T i;
        T j;
    }

    Multiple type parameter

    class Demo2 <T, U>
    {
        T i;
        U j;
    }

    In psvm
    Syntax: ClassName <non-primitive type> objectName = new ClassName<non-primitive type(optional>();

    Demo <Integer> ob1 = new Demo<Integer>();
            ^                       ^
       type arguments        this is optional

    Demo <Integer> ob2 = new Demo<>()
    Demo <String> ob3 = new Demo<>();
    Demo2 <Double,Double> ob4 = new Demo2<>();


    Upper Bound in generics
    Syntax: class ClassName<T extends UpperBoundClass> {}

    -> the type T can only be the UpperBoundClass or its subclass
    -> Any class can be a UpperBoundClass, it tells the generic type <T> that it can
       only be the UpperBoundClass or its subclass

    Upper Bound can also have interfaces
    Syntax: class ClassName<T extends UpperBoundClass & UpperBoundInterface1, UpperBoundInterface2> {}

    -> Here, T can be only class that extends UpperBoundClass and
       implements all the upper bound interfaces



*/

class SingleData <T>
{
    T i;

    public SingleData(T i) {
        this.i = i;
    }

    T getI()
    {
        return this.i;
    }

    void setI(T i)
    {
        this.i = i;
    }

}

class PairData<T,U>
{
    T i;
    U j;

    public PairData(T i, U j) {
        this.i = i;
        this.j = j;
    }

    void printData()
    {
        System.out.println("(PairData) i= " + i + ", j= " + j);
    }

}

public class Info {
    public static void main(String[] args) {

        //BEFORE STARTING GENERICS

        System.out.println("\nObjects as Universal class:");
        //Object can hold any type values
        //as Object is the parent class of each and every class
        Object ob1 = 9; // upcasting and autoboxing
        Object ob2 = "Amarjit"; // upcasting and autoboxing
        Object ob3 = false; // upcasting and autoboxing
        System.out.println("ob1 : " + ob1);
        System.out.println("ob2 : " + ob2);
        System.out.println("ob3 : " + ob3);
        //these can be used in method parameter, return type as well


        //Generics
        System.out.println("\nGenerics: ");
        SingleData<Integer> gOb1 = new SingleData<>(8);
        SingleData<String> gOb2 = new SingleData<>("Amarjit");
        System.out.println("SingleData<Integer> gOb1 : " + gOb1.getI());
        System.out.println("SingleData<String> gOb2 : " + gOb2.getI());
        //generics don't lost the type information
        System.out.println("Use string's method on gOb2: " + gOb2.getI().toUpperCase());

        //gOb1.setI("Amarjit"); <- compilation err as gOb1 is declared as Integer
        //So, generic is safe from runtime error

        //multiple type argument
        PairData<String,Integer> gOb3 = new PairData<>("Amarjit", 88);
        gOb3.printData();
        PairData<Integer,Integer> gOB4 = new PairData<>(45,46);
        gOB4.printData();

        //calling generics method
        //here we don't need to tell the Type java do it automatically
        //this is called type inference
        display1(4);
        display1("Amarjit");
        display2("Hello","World");
        display2(15,"Apple");
    }

    //Generics methods
    //<T> returnType methodName(T parameter)
    public static <T> void display1(T i)
    {
        System.out.println("Display1(): " + i);
    }

    //multiple type parameter
    public static <T,U> void display2(T i, U j)
    {
        System.out.println("Display2(): i= " + i + ", j= " + j);
    }
}


/*
    * Type Erasures
    A process where the java compiler removes all the generics type information
    during compilation to convert generics code into ordinary bytecodes

    Q Does JVM know generics?
    Ans: No, Java don't know about generics. Before code reach JVM compiler
    remove all the generics type can convert into normal code on the byte code.

    Java doing this to continue backward compatibility.

    For example:
        file.java:
        class Temp<T>
        {
            T value;
        }

        file.class:
        class Temp
        {
            Object value;
        }

    Case 1: If no bounding -> replace with Object
    class Temp<T>
    {
        T value;
    }

    Converted into:
    class Temp
    {
        Object value;
    }

    Case 2: If bounded -> replace with bound
    class Temp<T extends Demo>
    {
        T value;
    }

    Converted into:
    class Temp
    {
        Demo value;
    }


    -> Insert cast automatically
    class Temp<T>
    {
        T value;
    }

    psvm
    {
        Temp<Demo> demo = new Temp<>();
        Demo x = demo.value;
    }

    converted into:
    class Temp
    {
        Object value;
    }

    psvm
    {
        Temp<Demo> demo = new Temp<>();
        Demo x = (Demo)demo; <- automatically casting type;
    }


    * Things that can not do with generics type
        1. instanceof operator cannot be used with generics
           For example:
           List<String> l = new ArrayList<>();
           -> if(l instanceof List<String>) this is wrong (compilation err)

        2. Cannot overload method with generics
           For example:
           void print(List<String> l){...}
           void print(List<Integer> l({...}
           -> this is not allowed as in the byte code generics from the both methods
              will be removed, and it will have same signature.

    * Compiler generated bridge method
      For example:
      class Parent<T>
      {
            T get()
            {
                return null;
            }
      }
      class Child extends Parent<String>
      {
            @Override
            String get()
            {
                return "Hello";
            }

            //this part below is the BRIDGE METHODS generated by the compiler
            Object get()
            {
                get(); //calling the String get() inside it
            }
      }


    Q Why generics not supported primitive?
    Ans: Generics is not supported for primitive type because of the type erasure
         that compiler replaced all the generics into Object class object or
         bound class object in the byte code. And Primitive type does not extend
         Object class as they are not class to it's not compatible to convert into
         Object class objects.



*/
