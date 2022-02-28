package com.company;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringToReverse = in.nextLine();
        if (stringToReverse.equals(StringReverse(stringToReverse))) {
            System.out.println("This is Polindrome");
        }
        else {
            System.out.println("No Polindrome");
        }
    }

    public static String StringReverse(String str) {
        String rev = "";
        for (int i = str.length(); i != 0; i-- ) {
            rev += String.valueOf(str.charAt(i - 1));

        }

        return rev;
    }
}
