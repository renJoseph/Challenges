package challenges.easy.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] ints = new int[] { 1, 1, 2, 3, 5, 6, 6, 7, 7, 7, 7, 7, 8, 9, 9 };
        int i = removeDuplicates(ints);
        System.out.println("Length: " + i + "\n" + Arrays.toString(Arrays.copyOfRange(ints, 0, i)));
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
    // Duplicates from Sorted Array.
    // Memory Usage: 40.4 MB, less than 97.76% of Java online submissions for Remove
    // Duplicates from Sorted Array.
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int num : nums) {
            if (num != nums[i]) {
                i++;
                nums[i] = num;
            }
        }
        return i + 1;
    }
}
