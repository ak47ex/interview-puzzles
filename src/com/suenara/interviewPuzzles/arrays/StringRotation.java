package com.suenara.interviewPuzzles.arrays;

/**
 * String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
 * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isRotation("break", "break"));
        System.out.println(isRotation("break", "akbre"));
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    public static boolean isRotation(String origin, String rotation) {
        if (origin.length() != rotation.length()) return false;

        int len = origin.length();

        int oi = 0;
        int ri = 0;

        int end = len;
        while (ri < len) {
            if (origin.charAt(oi) == rotation.charAt(ri)) {
                end = ri;
                while (origin.charAt(oi) == rotation.charAt(ri)) {
                    if (ri + 1 >= len) break;

                    oi++;
                    ri++;

                }
            }
            ri++;
            oi = 0;
        }

        if (end == 0) return true;

        oi = len - end;
        ri = 0;

        while (origin.charAt(oi) == rotation.charAt(ri)) {
            if (oi + 1 >= len) return true;
            oi++;
            ri++;
        }

        return false;
    }
}
