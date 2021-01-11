package challenges.hard.JumpGame2;

public class Solution3 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        System.out.println(jump(nums));
    }

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game
    // II.
    // Memory Usage: 40.9 MB, less than 85.84% of Java online submissions for Jump
    // Game II.
    // Fast, memory optimised
    public static int jump(int[] nums) {
        int jumps = 0, targetIndex = nums.length - 1, maxSum, maxIndex, sum, index, jumpSize;
        for (index = 0; index < targetIndex;) {
            if (nums[index] >= (targetIndex - index)) {
                jumps++;
                break;
            }
            maxSum = 0;
            maxIndex = 0;
            for (jumpSize = 1; jumpSize <= nums[index]; jumpSize++) {
                sum = jumpSize + nums[index + jumpSize];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxIndex = jumpSize;
                }
            }
            index += maxIndex;
            jumps++;
        }
        return jumps;
    }
}
