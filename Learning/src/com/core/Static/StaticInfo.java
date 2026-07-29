package com.core.Static;
/*
    static basic
    static data access
    accessing non-static method or data inside static method

    - static method cannot be overridden (but no compilation error)
    - static variable are not store in heap mem.
    - static variable are called class variable
    - other variable are called instance variable or object variable
    - static cannot be a parameter of a method
        void display(static int temp) -> this is not allowed
    - a class cannot be
        static class Demo -> this is not allowed
        {
        {
*/


class Human
{
    String name;
    int age;
    static long population;

    //for static variable we can assign value on initialization;
    static int temp = 5; // this is allowed


    Human(String name, int age)
    {
        this.name = name;
        this.age = age;

        //this.population is correct but the convention is
        Human.population++ ;
    }

    public Human() {
    }

    //static member function / static method can only access a static data member
    //or methode of the class directly.
    //Static methode cannot use "this" keywords as "this" keyword refer the current
    //object but the static method belongs to the class
    static void printPopulation()
    {
        System.out.println("The total population is: " + population);
        //it cannot access the non-static members like age, name
        //System.out.println(age) // this is wrong!
        //System.out.println(name) // this is wrong!
    }

    //but the non-static data member can be access by the static method
    //by passing an object as parameter. So that the specific data member
    //of the object can access as non-static member belong to the object.
    static void printInfo(Human h)
    {
        System.out.println("\nPerson information");
        System.out.println("Age : " + h.age);
        System.out.println("Name : " + h.name);
        System.out.println("Total Population: " + population);
    }

    //static method cannot be overriden
    static void printNum()
    {
        System.out.println("Human.printNum: 10");
    }

}

class StaticDemo extends Human
{
    static  String staticMessage = "Nested class: staticMessage: Hello";
    static void printNum()
    {
        System.out.println("StaticDemo.printNum: 11");
    }

    //static class: a nested class can be static
    public static class StaticNestedClass {
        public void display() {
            //  Allowed: Can access static variables of outer class
            System.out.println(staticMessage);

            //COMPILE ERROR: Cannot make a static reference to the non-static field
            // System.out.println(instanceMessage);
        }
    }

}


public class StaticInfo {
    public static void main(String[] args) {
        Human amarjit = new Human("amarjit", 21);
        Human sunanda = new Human("sunanda", 31);

        //accessing non-static method
        StaticInfo obj = new StaticInfo();
        obj.display();
        //System.out.println(amarjit.population) is correct but the convention is
        System.out.println(Human.population);
        Human.printPopulation();
        Human.printInfo(sunanda);

        //here the reference is Human and object is StaticDemo
        //since, the printNum Methode is static, the printNum of Human class
        //will be executed
        //this is because the static member belongs to the class not to the object
        //So, here sob is the reference of the class Human
        //and new StaticDemo is the object of the StaticDemo Class
        //when sob.printNum() is called the method belong to the class of sob execute.
        //But, there is no compilation error here
        Human sob = new StaticDemo();
        sob.printNum();

        // Instantiate the static nested class directly
        StaticDemo.StaticNestedClass nestedObject = new StaticDemo.StaticNestedClass();
        nestedObject.display();


    }

    private void display()
    {
        System.out.print("Total human population (total obj created): ");
    }
}
