package com.LambdaExpression.ComparatorInfo;
import java.util.*;

/*

    INTRODUCTION TO LAMBDA EXPRESSION
        Syntax
        (Parameters) -> expression

    1. Multi parameter
        (p1,p2) -> p1+p2

    2. Single parameter
        (p1) -> p1*p1
        or
        p1 -> p1*p1

    3. No Parameter
        () -> System.out.println("hello");

    4. Multiline
        (p1,p2) -> {
            int a = 6;
            int b = 5;
            int result = a*b+p1*p2;
            return result;
        }

*/

public class ComparatorInfo {
    public static void main(String[] args) {
        List<Student> st1 = new ArrayList<>();
        st1.add(new Student("Amarjit",34,48));
        st1.add(new Student("Rexgona",15,34));
        st1.add(new Student("Sunanda",13,45));

        Collections.sort(st1);
        System.out.println("Sort using the Comparable interface");
        for(Student s : st1)
        {
            System.out.println(s.name + ", " + s.roll + ", " + s.mark);
        }

        //by using the Comparator interface we don't need the Comparable interface
        //at all
        Comparator<Student> byName = new SortByName();
        Comparator<Student> byMark = new SortByMark();
        Comparator<Student> byRoll = new SortByRoll();

        //Note that Collections.sort() is an overloaded method
        Collections.sort(st1,byMark);
        //the st1 list is now sorted by mark using Comparator interface
        System.out.println("\nst1 sort by mark using Comparator interface");
        for(Student s : st1)
        {
            System.out.println(s.name + ", " + s.roll + ", " + s.mark);
        }

        Collections.sort(st1,byRoll);
        //the st1 list is now sorted by mark using Comparator interface
        System.out.println("\nst1 sort by roll using Comparator interface");
        for(Student s : st1)
        {
            System.out.println(s.name + ", " + s.roll + ", " + s.mark);
        }

        //here we can also use anonymous class instead of defining the compare method
        //separately
        //sorting by name
        System.out.println("\nSorting the st1 by name using anonymous class");
        Collections.sort(st1, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for(Student s : st1)
        {
            System.out.println(s.name + ", " + s.roll + ", " + s.mark);
        }

        //now comes the lambda expression
        //sorting the st1 by mark using lambda expression
        System.out.println("\nSorting the st1 by mark using lambda expression");
        Collections.sort(st1,(s1,s2)->s1.mark-s2.mark);
        for(Student s: st1)
        {
            System.out.println(s.name + ", " + s.roll + ", " + s.mark);
        }

    }
}

class Student implements Comparable<Student>
{
    String name;
    int roll;
    int mark;

    public Student(String name, int roll, int mark) {
        this.name = name;
        this.roll = roll;
        this.mark = mark;
    }


    //when the class needs to be sort in terms of marks
    //but this is tightly couple
    @Override
    public int compareTo(Student o) {
        return this.mark - o.mark;
    }
}

//for loosely coupling - use Comparator interface
class SortByName implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);//using the compareTo of String class
    }
}

class SortByRoll implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.roll - o2.roll;
    }
}

class SortByMark implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.mark - o2.mark;
    }
}


