package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final int SOMETHING = 100;

    public static void main(String[] args) {
        System.out.println("This variable can't be changed. SOMETHING = " +SOMETHING);

        // arrays
        int[] heights = new int[5];
        heights[0] = 100;
        heights[1] = 200;
        heights[2] = 300;
        heights[3] = 400;
        heights[4] = 500;
        System.out.println("Height Array: " + Arrays.toString(heights));

        // string -> making string upper case and lower case
        String str1 = "Shahriar";
        String str2 = "Tamjid";
        System.out.println("Upper Case: " + str1.toUpperCase());
        System.out.println("Lower Case: " +str2.toLowerCase());

        // type casting
        double d1 = 3.1416;
        int i1 = (int)d1;
        System.out.println("Casted variable (int): " +i1);

        // changing int to string
        int i2 = 33;
        String str3 = String.valueOf(i2);
        System.out.println("int to String: " + str3);

        // primitive type to primitive wrapper class conversion
        int i3 = 321;
        Integer i4 = i3;
        System.out.println("Wrapped Integer: " +i4);
        // perks of using wrapper class
        // we can use NULL values in wrapper class

        // difference between "==" and ".equals"
        // in terms of string "==" checks memory location
        // but ".equals" checks the actual value inside
        String str4 = "abc";
        String str5 = "abc";
        System.out.println(str4 == str5);

        String str6 = new String("abc");
        System.out.println(str4 == str6);
        System.out.println(str5 == str6);

        System.out.println("Now it's time for .equals()");
        System.out.println(str4.equals(str6));
        System.out.println(str5.equals(str6));
    }
}