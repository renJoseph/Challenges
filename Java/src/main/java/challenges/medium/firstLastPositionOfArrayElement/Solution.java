package challenges.medium.firstLastPositionOfArrayElement;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 2, 2 };
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First
    // and Last Position of Element in Sorted Array.
    // Memory Usage: 41.9 MB, less than 92.38% of Java online submissions for Find
    // First and Last Position of Element in Sorted Array.
    public static int[] searchRange(int[] nums, int target) {
        int first = Arrays.binarySearch(nums, 0, nums.length, target);
        if (first < 0) {
            return new int[] { -1, -1 };
        } else {
            int last = first;
            for (; first > 0 && nums[first - 1] == target; first--) {}
            for (; last < nums.length - 1 && nums[last + 1] == target; last++) {}
            return new int[] { first, last };
        }
    }
}
