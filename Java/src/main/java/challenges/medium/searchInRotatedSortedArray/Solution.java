package challenges.medium.searchInRotatedSortedArray;

public class Solution {
    public static void main(String[] args) {

    }
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in
    // Rotated Sorted Array.
    // Memory Usage: 38.4 MB, less than 62.60% of Java online submissions for Search
    // in Rotated Sorted Array.
    public int search(int[] nums, int target) {
        int i = 0;
        for (int n : nums) {
            if (n == target) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
