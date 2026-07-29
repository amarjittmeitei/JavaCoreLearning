package com.core.Constructor;//constructor overloading
//calling a constructor inside a constructor


//impt question
// Q. Can we manually call a constructor of a class
// Ans: No, we cannot manually call a constructor of a class. It is automatically
//      called when only when the object of the class is created.

class Student
{
    int roll;
    String name;
    double marks;

    //chaining of constructor

    //Student(){}
    Student()
    {
        //calling a constructor inside a constructor
        //(this) calling the following constructor
        // Student(int roll, String name, double marks)
        // {
        //      this.roll = roll;
        //      this.name = name;
        //      this.marks = marks;
        // }

        this(2,"amarjit",45);
    }
    Student(int roll, String name, double marks)
    {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }
}


public class ConstructorDemo {
    public static void main(String[] args)
    {
        Student st = new Student();
        System.out.println(st.name);

        Student st2 = new Student();
        st2.name = "moirangthem";
        System.out.println(st2.name);;

        Student random = new Student();
        System.out.println(random.name);
   }

}
