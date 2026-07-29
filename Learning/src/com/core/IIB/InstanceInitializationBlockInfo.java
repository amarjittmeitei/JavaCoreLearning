package com.core.IIB;

public class InstanceInitializationBlockInfo {

    /*
        An Instance Initialization Block is a block of code inside a Java
        class that runs automatically every single time you create a new object
        of that class.

        Why use it if we have Constructors?
            1. Sharing Code Across Multiple ConstructorsIf your class has 3 or 4
        overloaded constructors, and you want a specific piece of code to run
        for all of them, you can place that code inside an instance block.
        This prevents you from repeating the code in every constructor.

            2. Initializing Anonymous Inner ClassesWhen you create an anonymous
        inner class (a class with no name created on the fly), it cannot have
        a constructor because constructors must match the class name. An
        instance initialization block is the only way to run setup code for them.

        - The variable declare inside this block are stay only the scope of the
        block cannot be access outside the block. But the data member of the class
        and value is assigned inside the instance initialization block can be access
        outside the scope just like a value assigned inside a constructor.

        - you cannot define a method inside this block ( lambda function is allowed)

        - you can call a method that created anywhere in the class

    */

    int x;
    int y;

    {
        //this print everytime an object is created
        System.out.println("An object is created");

        //this is allowed and values of x and y stay even outside the block
        x = 10;
        y = 11;

        //this is allowed but its existence is only inside the block
        int temp = 10;
    }

    void tempPrint()
    {

        //System.out.println(temp); //this is not allowed, temp does not exist here
    }
}
