package com.core.JavaString;

/*

   -> StringBuilder and StringBuffer are in java.lang package
   -> AbstractStringBuilder is the parent class of the StringBuilder and
      StringBuffer classes.
   -> StringBuilder and StringBuffer is mutable
   -> StringBuilder is not threat safe
   -> StringBuffer is threat safe, avoid race condition

   class StringBuilder extends AbstractStringBuilder
   {
        byte[] values; // coder is handle internally
        int count;
   }

   count -> total size taken to store actual string on the byte[] values.

   capacity -> values also have other extra spaces to give the room for append as
               StringBuilder are mutable.

               The default initial capacity is 16.
               If the capacity is fulled new array for values will be created with
               *(newCapacity = (currentCapacity * 2) + 2)
               and the existing byte array value will be copied to the new byte array,
               and it will become the new values. If this new capacity is also full the
               same will be repeated.


    StringBuffer have larger overhead then StringBuilder due to its
    threat safety feature. So in production StringBuilder is used about 90%
    over the StringBuffer

*/


public class StringBuilderInfo {

    public static void main(String[] args)
    {
        //constructors in StringBuilder
        StringBuilder sb1 = new StringBuilder(); //capacity = 16 (default)
        StringBuilder sb2 = new StringBuilder(50); // capacity = 16
        StringBuilder sb3 = new StringBuilder("hello"); // count = 5; capacity = 5+16 = 21

        System.out.println("sb3 = " + sb3);

        //built-in methods of StringBuilder
        System.out.println("\nBuilt-in method of StringBuilder");
        //1. append()
        sb3.append(" World");
        System.out.println("sb3.append(\" World\") : " + sb3);

        //2. insert(offset,char)
        sb3.insert(0,'X');
        System.out.println("sb3.insert(0,'X') : " + sb3);

        //3. delete()
        sb3.delete(7,10);
        System.out.println("sb3.delete(7,12) : " + sb3);

        //4. deleteChatAt(int)
        sb3.deleteCharAt(5);
        System.out.println("sb3.deleteCharAt(5); : " + sb3);

        //5. replace(int start, int end, string)
        sb3.replace(0,4,"Hello");
        System.out.println("sb3.replace(0,4,\"Hello\") : " + sb3);

        //6. reverse()
        sb3.reverse();
        System.out.println("sb3.reverse() : " + sb3);

        //7. chatAt(int index)
        System.out.println("sb3.charAt(1) : " + sb3.charAt(1));

        //7. setCharAt(int index, char ch)
        sb3.setCharAt(1,'X');
        System.out.println("sb3.setCharAt(1,'X') : " + sb3);

        //8. length()
        System.out.println("sb3.length() : " + sb3.length());

        //9. capacity()
        System.out.println("sb3.capcity() : " + sb3.capacity());

        //10. ensureCapacity() -> to set the capacity out of the constructor
        sb3.ensureCapacity(40);
        System.out.println("Current capacity after sb3.ensureCapacity : " + sb3.capacity());

        //11. trimToSize -> reduce the capacity to size on only require for current string
        sb3.trimToSize();
        System.out.println("After sb3.trimTiSize() : " + sb3.capacity());


        //StringBuilder does not override the equal() method
        System.out.println("\nStringBuilder does not override the equal() method");
        StringBuilder tempSb1 = new StringBuilder("Amarjit");
        StringBuilder tempSb2 = new StringBuilder("Amarjit");
        System.out.println("tempSb1 == tepmSb2 : " + (tempSb1 == tempSb2));

        /*
            StringBuffer is all similar to StringBuilder including all the
            built-in methods only the StringBuffer is threat safe.
        */


    }

}
