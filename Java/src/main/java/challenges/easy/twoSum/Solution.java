package challenges.easy.twoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    if (i == j) {
                        continue;
                    } else {
                        return new int[] { i, j };
                    }
                }
            }
        }
        return null;
    }
}
