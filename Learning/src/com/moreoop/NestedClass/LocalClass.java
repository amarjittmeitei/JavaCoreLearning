package com.moreoop.NestedClass;

/*

    A local class in Java is a nested class that is defined inside
    a block of code, most commonly inside a method body.

    It can be defined inside any code block
        - inside constructor
        - inside method body
        - inside conditional block
        - inside loop block
        - inside static block
        - inside IIB
    But their existence is only inside the block like other local member


*/
public class LocalClass {

    private static final int a = 10;
    void demo()
    {
        //the local class can access only the final local fields
        // and effective final field
        //An effectively final variable is a variable that is not
        //explicitly marked with the final keyword, but its value
        //never changes after it is initialized.

        final int x = 20;
        int y = 21;

        int z = 22;
        z = 23;

        class Local
        {
            void display()
            {
                System.out.println("This is from the local class: " +
                        "LocalClass.demo().Local.display()");

                //All the outer class member can be access by the local class
                System.out.println("Accessing outer class field: " + a);

                //x and y can be access as x is final and y is effective final
                System.out.println("Accessing final local field: " + x);
                System.out.println("Accessing effective final local field: " + y);

                //but the z is not final and effective final
                // System.out.println("Accessing final local field: " + z);//-> compilation error

            }


        }

        Local local = new Local();
        local.display();
    }


}
