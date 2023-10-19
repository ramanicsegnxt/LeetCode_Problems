package com.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    // using sorting without extra space where ordering doesn't matter
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[] {i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int val = target - nums[idx];
            if (map.containsKey(val)) {
                return new int[] {map.get(val), idx};
            }
            map.put(nums[idx], idx);
        }
        return new int[] {-1, -1};
    }
}
