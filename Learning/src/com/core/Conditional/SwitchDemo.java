package com.core.Conditional;//java support string a case value

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args)
    {
        String fruit;
        System.out.print("Enter a name of fruit: ");
        Scanner sc = new Scanner(System.in);
        fruit = sc.next();
        switch(fruit)
        {
            case "apple":
                System.out.println("An apple a day keeps the doctor out");
                break;

            case "lemon":
                System.out.println("Lemon can use for making detox water");
                break;

            case "watermelon":
                System.out.println("90% of the watermelon is water");
                break;

            default:
                System.out.println("Your fruit is not found, try another!");
        }
    }
}
