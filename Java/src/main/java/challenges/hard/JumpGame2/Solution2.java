package challenges.hard.JumpGame2;

import java.util.Collections;
import java.util.LinkedList;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        System.out.println(jump(nums));
    }
    // Runtime: 2 ms	
    // Memory: 45.1 MB
    // Improved solution, fast but memory could be optimised
    // single solution now generated rather than every possibility - list not needed
    // for loop may now be used - recursion is unnecessary
    public static int jump(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int target = nums.length - 1;
        generateResults(list, nums, 0, 0, target);
        return Collections.min(list);
    }

    public static void generateResults(LinkedList<Integer> list, int[] nums, int index, int jumps, int target) {
        if (index >= target || nums[index] == 0) {
            if (index == target) {
                list.add(jumps);
            }
            return;
        } else {
            if (nums[index] >= (target - index)) {
                generateResults(list, nums, target, jumps + 1, target);
            } else {
                int maxValue = 0;
                int maxIndex = 0;
                for (int i = 1; i <= nums[index]; i++) {
                    int nextValue = nums[index + i];
                    int sum = i + nextValue;
                    if (sum > maxValue && nextValue != 0) {
                        maxValue = sum;
                        maxIndex = i;
                    }
                }
                generateResults(list, nums, index + maxIndex, jumps + 1, target);
            }
        }
    }
}
