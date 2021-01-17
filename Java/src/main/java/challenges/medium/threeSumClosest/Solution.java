package challenges.medium.threeSumClosest;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 4;
        System.out.println(threeSumClosest(nums, target));
    }

    // Runtime: 3 ms, faster than 98.51% of Java online submissions for 3Sum
    // Closest.
    // Memory Usage: 38.3 MB, less than 97.64% of Java online submissions for 3Sum
    // Closest.

    // May be more efficient to implement a binary search of target/3 for a mid-number
    // then increment/decrement the mid number based on result > or < than target
    // val
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int lnum = nums[lo], hnum = nums[hi], diff = nums[i] + lnum + hnum - target;
                if (diff == 0) {
                    return target;
                } else {
                    if (Math.abs(minDiff) - Math.abs(diff) > 0)
                        minDiff = diff;
                    if (diff > 0) {
                        while (hi > lo && nums[hi] == hnum)
                            hi--;
                    } else {
                        while (hi > lo && nums[lo] == lnum)
                            lo++;
                    }
                }
            }
        }
        return target + minDiff;
    }
}
