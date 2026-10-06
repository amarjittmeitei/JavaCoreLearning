package com.exceptionHandling;

public class Basic {
    public static void main(String[] args) {
        System.out.println("start");

        try{
            int a = 5;
            int b = 0;
            System.out.println(a/b);

            //if exception is there the following code is unreachable
            System.out.println("mid");
        }
        //multiple catch block are allowed
        catch (ArithmeticException e)
        {
            System.out.println("cannot divided by zero");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("invalid argument");
        }
        //after java7 sibling exceptions can be written in one catch block
        //here IllegalStateException and ClassCastException are
        //sibling exception. So,

        catch(IllegalStateException |
                ClassCastException e)
        {
            System.out.println("Common exception are there!");
        }



        //Higher hierarchy exception have other exception catch block unreachable
//        catch (NullPointerException e)
//        {
//            System.out.println("Null are not allowed");
//        }
        catch (NullPointerException e)
        {
            System.out.println("Null are not allowed");
        }
        //higher hierarchy exception should be keep at the bottom
        //otherwise the lower hierarchy exception will be unreachable
        catch (Exception e)
        {
            System.out.println("An generic exception is there");
        }
        System.out.println("end");
    }
}
