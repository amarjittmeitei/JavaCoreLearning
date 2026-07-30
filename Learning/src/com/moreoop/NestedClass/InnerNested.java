package com.moreoop.NestedClass;



public class InnerNested {

    static int i = 10;
    int j = 11;
    int k = 12;

    class Inner2
    {
        int k = 13;

        //simple method demonstration
        void display1(int i)
        {
            System.out.println("Inner class display method: " + i);
        }

        //inner nested class can directly access outer's static member
        void display2()
        {
            System.out.println("Outer static field: " + i);
        }

        //inner nested class can directly access outer's non-static members
        void display3()
        {
            System.out.println("Outer non static member: " + j);
        }

        //if inner class have a member it same signature with outer class
        //the member of inner class will get the priority of access
        void display4()
        {
            //here inner class k = 13 will get the priority
            System.out.println("Outer and inner class have same variable name: " +k);
            //to access the outer member directly k = 12
            System.out.println("Accessing outer member directly when inner class " +
                    "have member with same name: " + InnerNested.this.k);
        }

        //After JAVA 16 static member inside inner nested class is allowed
        static int m;
        void setStatic(int i)
        {
            m = i;
        }

        void getStatic()
        {
            System.out.println("The static member inside inner nested class: "+m);
        }

    }
}
