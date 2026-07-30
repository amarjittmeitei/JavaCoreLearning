package com.moreoop.NestedClass;

public class AnonymousClass {

    /*

        An anonymous class in Java is a specialized inner
        class that has no name and is declared and instantiated
        at the exact same time in a single line of code.

        its like single inheritance and create child object with
        parent reference
            Parent ob = new Child();
        So, the same rule in this case is applied to the anonymous class

        - Anonymous class cannot have a constructor as constructor and the class
        name should be same but the anonymous class don't have a class name.

        - If anonymous class is inside a local block it will be local anonymous
        class. And the rules for both local class and anonymous class will be
        applied at the same time

    */

    void display()
    {
        System.out.println("Original method: Hello");
    }


}
