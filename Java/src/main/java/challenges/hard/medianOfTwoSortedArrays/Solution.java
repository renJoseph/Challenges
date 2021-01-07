package challenges.hard.medianOfTwoSortedArrays;

import java.util.Arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 }, nums2 = { 5, 6 };
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    // Runtime: 2 ms, faster than 99.69% of Java online submissions for Median of
    // Two Sorted Arrays.
    // Memory Usage: 40.1 MB, less than 82.70% of Java online submissions for Median
    // of Two Sorted Arrays.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, arrLen = len1 + len2;
        int[] arr = new int[arrLen];
        for (int i = 0; i < len1; i++)
            arr[i] = nums1[i];
        for (int j = 0; j < len2; j++)
            arr[len1 + j] = nums2[j];
        Arrays.sort(arr);
        return (arrLen % 2 != 0) ? (double) arr[(arrLen - 1) / 2]
                : (double) (arr[arrLen / 2] + arr[(arrLen / 2) - 1]) / 2;
    }
}
