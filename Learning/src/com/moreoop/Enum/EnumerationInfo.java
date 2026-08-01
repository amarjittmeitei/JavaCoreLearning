package com.moreoop.Enum;

/*
    ENUMERATION (ENUM)
    Pre defined set of constants
    An enum (short for enumeration) is a special Java data
    type used to define a collection of fixed, unchanging constants.

    Syntax:
        enum Enum_Name
        {
            STATUS_1, -> as constructor are added STATUS_1(40)
            {
                as abstract methods are there to implement
            },
            STATUS_2 , -> as constructor are added STATUS_2(41),
            {
                as abstract methods are there to implement
            }
            ...
            ...
            STATUS_N -> as constructor are added STATUS_N(60);
            {
                as abstract methods are there to implement
            };

            //other variables can be defined here
            private int a;

            //use defined methods can be added
            public void getA()
            {
                return this.a;
            }

            //even the abstract method can be added
            //it should be implements by each object inside it
            //using anonymous class
            abstract void change();

            //constructor can be added
            Enum_Name(int i)
            {
                this.a = i;
            }
        }

    Internally, enum is a special type of class.
    it extends Enum Class -> Enum is inside the java.lang package
        final class Enum_Name extends Enum <Enum_Name>
        {
            public static final Enum_Name STATUS_1 = new Enum_Name(40, constructors are added)
            {
                as abstract methods are there to implement
            };
            public static final Enum_Name STATUS_2 = new Enum_Name(41, constructors are added)
            {
                as abstract methods are there to implement
            };;
            public static final Enum_Name STATUS_3 = new Enum_Name(42, constructors are added)
            {
                as abstract methods are there to implement
            };;

            //constructor is private cannot create object outside the class
            private Enum_Name()
            {
                //empty
            }

            //other user declared variables are
            private int a;

            //other user defined methods are
            public void getA()
            {
                return this.a;
            }

            //other abstract methods are there even it is a final class
            //this is where java compiler cheat
            //it is an exception to rule that "final class cannot be abstract"
            abstract void change();

            //constructors added by the user are converted into private
            private Enum_Name(int i)
            {
                this.a = i;
            }

            //also contain other built-in methods
            Some important built-in methods
            1. value();
            2. valueOf(String);
            3. name();
            4. ordinal();

        }

        So, outside the class
            Enum_Name ob = new Enum_Name(); is not allowed as the constructor was private
        But, those object created inside the class are already in the heap mem.
            Enum_Name ob = Enum_Name.STATUS_1; -> is legal, STATUS_1 is the static fields
                                                  inside the class
        Only those object created inside the Enum_Class can be use outside the class.

    Some important built-in methods
        1. name() -> this method return string type which contain the constant of enum

                     Enum_Name ob = Enum_Name.STATUS_1;
                     ob.name() -> "STATUS_1"

        2. ordinal() -> this methode return an int which contain the index of the enum
                        constant

                        Enum_Name ob = Enum_Name.STATUS_1;
                        ob.ordinal() -> 0
        --- this two methods are inside the java.lang.Enum class ---

        --- following methods are compiler generated ---
        3. values() -> this method return an array of all the constant of the enum
        4. valueOf(String) -> this method convert a string into enum constant that
                              are already defined inside the enum.

                              String temp = "STATUS_1";
                              Enum_Name ob = valueOf(temp);
                              ob.name() -> "STATUS_1"

        * Object class is also extends here. So, all the corresponding methods like
          toString(), hashCode(), clone(), equal() can be used.


    Why enum? Problem without enum in status variables
        1. Type safety
        2. Poor readability
        3. No grouping of related entities
        4. Status variable with duplicated values may cause bug




*/


enum Payment
{
    SUCCESS,
    FAILED,
    PENDING
}

//enum can have user defined members fields and method
//even it can have abstract method
//it can have constructor
//other interface can be implements
//but other class cannot be extended as internally it extends Enum class
enum Direction
{
    NORTH(0) // all the abstract methods need to implement by
                    // each constant using anonymous class
            {
                @Override
                void move()
                {
                    System.out.println("Move top");
                }
            },
    EAST(90)
            {
                @Override
                void move()
                {
                    System.out.println("Move right");
                }
            },
    SOUTH(180)
            {
                @Override
                void move()
                {
                    System.out.println("Move down");
                }
            },
    WEST(270)
            {
                @Override
                void move()
                {
                    System.out.println("Move left");
                }
            };

    private final int degree; //non-final fields are also allowed

    Direction(int degree) {
        this.degree = degree;
    }

    int getDegree()
    {
        return this.degree;
    }

    abstract void move();



}

public class EnumerationInfo {
    public static void main(String[] args) {
        Payment ptm = Payment.FAILED;

        //printing the enum constant, println() handle it even Payment.SUCCESS
        //is not a string
        System.out.println(ptm);
        System.out.println(Payment.PENDING);

        //converting enum constant into string
        System.out.println("\nconverting enum constant into string");
        String str1 = Payment.FAILED.name();
        System.out.println(str1);

        //getting the index of the enum constant
        System.out.println("\ngetting the index of the enum constant");
        int count = Payment.PENDING.ordinal();
        System.out.println(count);

        //converting str2 string into enum constant
        System.out.println("\nconverting str2 string into enum constant");
        String str2 = "FAILED";
        //the following line cause no compilation error
        //but cause runtime IllegalArgumentException as CANCEL is not a
        //constant of enum Payment
        //str2 = "CANCEL";
        Payment gpay = Payment.valueOf(str2);
        System.out.println(gpay);

        //the array of all the constant of the enum
        System.out.println("\nthe array of all the constant of the enum");
        Payment[] arr = Payment.values();
        for(Payment i : arr)
        {
            System.out.println(i);
        }

        //enum direction
        System.out.println("\nENUM DIRECTION");
        Direction direction1 = Direction.EAST;
        Direction direction2 = Direction.SOUTH;

        //using the enum getters
        System.out.println("Using the enum getters");
        System.out.println(direction1.getDegree());
        System.out.println(direction2.getDegree());

        //calling the implemented abstract methods
        System.out.println("\nCalling the implemented abstract methods");
        direction1.move();
        direction2.move();

        //other built-in method of Object class can also be used
    }
}
