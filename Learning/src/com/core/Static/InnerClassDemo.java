package com.core.Static;


//only the class inside a class can be static
//the class outside any class cannot be static
//for example
/*

static class Demo -> this is wrong

*/

public class InnerClassDemo {

    //static class here is accepted
    //for example
    static class Inner
    {
        int id;

        Inner(int id)
        {
            this.id = id;
        }
        void display()
        {
            System.out.println("Hello from the inner static class id: " + this.id);
        }
    }

    public static void main(String[] args) {
        Inner ob1 = new Inner(1);
        Inner ob2 = new Inner(2);

        ob1.display();
        ob2.display();
    }

}
