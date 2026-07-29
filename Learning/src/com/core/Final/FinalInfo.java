package com.core.Final;

/*

    The "final" keyword can be used in
        - variable
        - method
        - function parameter
        - class
        but the usage are difference

    The naming convention of final keywords
        - Always use upper case for final variable
        - for word separator use underscore
        for example:
            final int PI_VALUE = 3.14;
            instead if final int piValue = 3.14;
        there is no strict rule for this naming convention the same rules for naming
        identifier is applied here


*/


//  final class can not create a child of that class
final class FinalClass
{
    //this class cannot be extended to other class
    //for example, let class Demo is outside this class:
    //  class Demo extends FinalClass
    //  {
    //      ....
    //  }
    //this is wrong

    int x;
    int y;

    public FinalClass() {
        x = 10;
        y = 11;
    }
}

//final method can not be overridden, but it inherits
//for example
class FinalMethodClass
{
    //this method cannot be overridden by any of it subclass
    //for example, lets suppose the class Demo2 is outside this class:
    //  class Demo2 extends FinalMethodClass
    //  {
    //      void display(){ .... ;}
    //  }
    //  this is wrong

    final void display()
    {
        System.out.println("FinalMethodeClass.display: Hello");
    }
}



//public class FinalInfo extends FinalClass //-> this is wrong as FinalClass is final
public class FinalInfo extends FinalMethodClass{


    //This is wrong, and it will cause compilation error as display is final
    //which cannot be overridden, but It's still inherited
    //    void display()
    //    {
    //
    //    }



    final int temp1 = 30; // the value can be assigned on declaration
    final int temp2; //if the value is not assigned on declaration it should be
    static final int temp3; //for static final variable if the assignment is
    //not done on declaration it should be done inside the static block or inside the
    //assigned inside the constructor otherwise there will be compilation error
    //constructor. But the recommendation is inside the static block to avoid
    //overriding the value every time an object is created

    public FinalInfo() {
        temp2 = 5;
    }

    static
    {
        temp3 = 6;
    }



}
