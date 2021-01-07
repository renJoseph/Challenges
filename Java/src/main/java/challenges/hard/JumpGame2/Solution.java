package challenges.hard.JumpGame2;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        System.out.println(jump(nums));
    }

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
            // Poorly optimised - generates every possible result and returns minimum
            for (int i = 1; i <= nums[index]; i++) {
            generateResults(list, nums, index + i, jumps + 1, target);
            }
        }
    }
}
