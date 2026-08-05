package com.core.JavaString;

public class BuiltinMethods {

    public static void main(String[] args) {


        //constructors of String class
        //default constructor
        String s1 = new String();// output-> ""
        System.out.println("String default constructor: " + s1);

        //Parameterized constructors
        String s2 = new String("Amarjit");
        System.out.println("Parameterized constructor: " + s2);

        //char[] array on constructor
        char[] arr = {'m','e','i','t','e','i'};
        String s3 = new String(arr);
        System.out.println("char[] arr on constructor: " + s3);

        //char[] array with offset and count on constructor
        String s4 = new String(arr,1,3);// range [1,3)
        System.out.println("char[] array with offset and count: " + s4);

        //byte[] array on constructor
        byte[] byArr = {65,66,67,68,69,70}; // ACSII of ABCDEF
        String s5 = new String(byArr);
        System.out.println("byte[] array on constructor: " + s5);

        //byte[] arr with offset and count on constructor
        String s6 = new String(byArr,2,4);//range [2,4)
        System.out.println("byte[] array with offset and count: " + s6);

        //StringBuilder object on constructor
        StringBuilder sb1 = new StringBuilder("Moirangthem");
        String s7 = new String(sb1);
        System.out.println("StringBuilder object on the constructor: " + s7);

        //StringBuffer object on constructor
        StringBuffer sb2 = new StringBuffer("Moirangthem");
        String s8 = new String(sb2);
        System.out.println("StringBuffer object on the constructor: " + s8);


        //Built-in methods of String
        String s9 = "Amarjit Moirangthem";
        String s10 = "   heirok   ";
        String s11 = "    ";
        String s12 = "";
        String s13 = "amarjit moirangthem";
        String s14 = "amarjit,sunanda,rexgona";
        System.out.println("\nBuilt-in methods");
        //Length/Emptiness
        //1. length()
        System.out.println("length() for \"" + s9 + "\" : " + s9.length());
        //2. isEmpty()
        System.out.println("isEmpty() for \"" + s9 + "\" : " + s9.isEmpty());
        System.out.println("isEmpty() for \"" + s11 + "\" : " + s11.isEmpty());
        System.out.println("isEmpty() for \"" + s12 + "\" : " + s12.isEmpty());
        //isBlank()
        System.out.println("isBlank() for \"" + s9 + "\" : " + s9.isBlank());
        System.out.println("isBlank() for \"" + s11 + "\" : " + s11.isBlank());
        System.out.println("isBlank() for \"" + s12 + "\" : " + s12.isBlank());

        //char access
        //1. charAt(int)
        System.out.println("charAt(4) for \"" + s9 + "\" : " + s9.charAt(4));
        //2. toCharArray
        char[] chArr = s9.toCharArray();
        System.out.print("toCharArray() for \"" + s9 + "\" : ");
        for(char i : chArr)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        //Comparison
        //1. equals() -> overridden by the String class
        System.out.println("equals() on \""+s9+"\" and \""+s13+"\": " + s9.equals(s13));
        System.out.println("equals() on \""+s9+"\" and \""+s10+"\" : " + s9.equals(s10));
        //3. s9.equalsIgnoreCase(s10) -> this compare and not case sensitive
        //2. compareTo() -> compare the sum of ASCII code
        System.out.println("compareTo() on \""+s9+"\" and \""+s13+"\": " + s9.compareTo(s13));
        System.out.println("compareTo() on \""+s9+"\" and \""+s10+"\" : " + s9.compareTo(s10));

        //searching
        //1. contains(string)
        System.out.println("contains(\"jit\") on \""+s9+"\" : " + s9.contains("jit"));
        //2. indexOf(char) -> return -1 if not found
        System.out.println("indexOf('t') on \""+s9+"\" : " + s9.indexOf('t'));
        //3. lastIndexOf(char) -> return -1 if not found
        System.out.println("lastIndexOf('t') on \""+s9+"\" : " + s9.lastIndexOf('t'));
        //4. startsWith(string)
        System.out.println("startsWith(\"t\") on \""+s9+"\" : " + s9.startsWith("t"));
        System.out.println("startsWith(\"A\") on \""+s9+"\" : " + s9.startsWith("A"));

        //extraction and transformation
        //1.substring(startIndex, endIndex) -> return string, range [startIndex,endIndex)
        System.out.println("substring(3,11) on \""+s9+"\" : " + s9.substring(3,11));
        System.out.println("substring(3) on \""+s9+"\" : " + s9.substring(3));

        //2. toUpperCase() -> return String
        System.out.println("toUpperCase() on \""+s9+"\" : " + s9.toUpperCase());

        //3. toLowerCase() -> return String
        System.out.println("toLowerCase() on \""+s9+"\" : " + s9.toLowerCase());

        //4. trim() -> return string
        System.out.println("trim() on \""+s9+"\" : " + s9.trim());
        System.out.println("trim() on \""+s10+"\" : " + s10.trim());

        //5. strip() same as trim but Unicode UTF16 friendly

        //6. repeat(int) -> return String
        System.out.println("repeat(2) on \""+s9+"\" : " + s9.repeat(2));

        //7. replace(oldChar, newChar) overload replace(oldString,newString) -> return String
        System.out.println("replace(\"rang\",\"XXXX\") on \""+s9+"\" : " + s9.replace("rang","XXXX"));

        //9. replaceAll() -> it use regex.

        //10. spit() -> return String[]
        //split String into multiple string based on a delimiter regex
        String[] srtArr = s14.split(",");
        System.out.println("split(\",\") on \""+s14+"\" : ");
        for(String s : srtArr)
        {
            System.out.println("\t"+s);
        }

        //11. join()
        System.out.println("join(\"-\",\"apple\",\"orange\",\"lemon\") : " +
                String.join("-","apple","orange","lemon"));


        //conversion

        //1. valueOf(int) -> return String
        String s15 =  String.valueOf(65);
        System.out.println("String s15 = String.valueOf(65) : " + s15);

        //2. getBytes() -> return byte[] arr , get ASCII/UTF16 code array
        byte[] bytArr = s9.getBytes();
        System.out.print("getBytes() for \""+s9+"\" : ");
        for(byte b : bytArr)
        {
            System.out.print(b+" ");
        }
        System.out.println();


        //Advance

        //1. intern() to the String object in string pool
        //creating an object on the heap. Also, we use the literal on the constructor
        //So, another object on the string pool is also created
        String tempStr1 = new String("hello world");
        String tempStr2 = tempStr1; //tempStr1 and tempStr2 point to the same object on
        //the heap. So, tempStr1 == tempStr2 is true
        System.out.println("tempStr1 == tempStr2 : " + (tempStr1 == tempStr2));
        String tempStr3 = tempStr1.intern(); // here tempStr3 point to the
        //object created on string pool. So, tempStr1 == tempStr3 is false
        System.out.println("tempStr1 == tempStr3 : " + (tempStr1 == tempStr3));

        //2. formate()
        int age = 23;
        System.out.println(String.format("Using formate() to print %s your age is %s"
                ,s9,age));





    }
}
