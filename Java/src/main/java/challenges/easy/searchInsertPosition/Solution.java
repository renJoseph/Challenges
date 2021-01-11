package challenges.easy.searchInsertPosition;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9 };
        System.out.println(searchInsert(nums, 5));
    }

    // https://leetcode.com/problems/search-insert-position/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search
    // Insert Position.
    // Memory Usage: 38.3 MB, less than 93.83% of Java online submissions for Search
    // Insert Position.
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) {
                return i;
            }
            if (num < target) {
                i += 1;
            }
        }
        return i;
    }
}
