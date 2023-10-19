package com.leetcode.problems.easy;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters
// https://www.youtube.com/watch?v=GS9TyovoU4c
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currentSubString = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (currentSubString.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                currentSubString.append(s.charAt(j));
                maxLength = Math.max(maxLength, currentSubString.length());
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringUsingMap(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> visitedChar = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if (visitedChar.containsKey(currentCharacter) && visitedChar.get(currentCharacter) >= left) {
                left = visitedChar.get(currentCharacter) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedChar.put(currentCharacter, right);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            int indexOfFirstAppearance = s.indexOf(s.charAt(right), left);
            if (indexOfFirstAppearance != right) {
                left = indexOfFirstAppearance + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
