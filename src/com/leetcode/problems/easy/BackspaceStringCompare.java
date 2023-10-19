package com.leetcode.problems.easy;

// https://leetcode.com/problems/backspace-string-compare/?envType=daily-question&envId=2023-10-19
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        return getActual(s).equals(getActual(t));
    }

    private static String getActual(String str) {
        StringBuilder actualString = new StringBuilder();
        int hashCount = 0;
        for (int idx = str.length() - 1; idx >= 0; idx--) {
            if (str.charAt(idx) == '#') {
                hashCount++;
                continue;
            }

            if (hashCount > 0) {
                hashCount--;
            } else {
                actualString.insert(0, str.charAt(idx));
            }
        }
        return actualString.toString();
    }
}
