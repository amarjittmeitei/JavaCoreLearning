package com.core.DeepShallowCopy;

public class DeepShallowCopy {

    int x;
    int y;


    public DeepShallowCopy(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public DeepShallowCopy(DeepShallowCopy ob) {
        this.x = ob.x;
        this.y = ob.y;
    }

    void display()
    {
        System.out.println("x= " + this.x + " y= " + this.y);
    }


    public static void main(String[] args) {
        //deep copy and shallow copy is about copying one object to another
        //in deep copy a copy of an object is created, the reference variable
        //of the original object the copy object will point to different object
        //in the heap mem.
        //In this case the changes in one object does not affect the copy.
        //Those are two independent objects.
        //for example
        System.out.println("Deep copy");
        DeepShallowCopy ob1 = new DeepShallowCopy(4,5);
        DeepShallowCopy ob2 = new DeepShallowCopy(ob1); //deep copying the ob1;

        ob1.display();
        ob2.display();

        ob2.x += 10;

        System.out.println("after increasing the value of ob2.x by 10");
        ob1.display();
        ob2.display();

        //in shallow copy, a copy of the object is created. And the reference
        //variable of the copy object is same as the original
        //this means the both original and copy object point to the same object
        //so the changes in any of the object will affect another
        //for example
        System.out.println("\nShallow copy");
        DeepShallowCopy ob3 = ob1;//shallow copying the ob1;
        ob1.display();
        ob3.display();
        ob3.x += 10;
        System.out.println("after increasing the value of ob2.x by 10");
        ob1.display();
        ob2.display();



    }
}
