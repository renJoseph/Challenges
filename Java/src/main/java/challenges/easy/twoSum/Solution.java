package challenges.easy.twoSum;

public class Solution {
    // https://leetcode.com/problems/two-sum/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
    // Memory Usage: 38.7 MB, less than 97.77% of Java online submissions for Two
    // Sum.
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j;
        for (int num1 : nums) {
            j = 0;
            for (int num2 : nums) {
                if (i == j) {
                    continue;
                }
                if (num1 + num2 == target) {
                    return new int[] { i, j };
                }
                j++;
            }
            i++;
        }
        return null;
    }
}
