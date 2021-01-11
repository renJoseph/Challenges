package challenges.medium.combinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(combinationSum(nums, 5));
    }

    // https://leetcode.com/problems/combination-sum/
    // Runtime: 4 ms, faster than 54.24% of Java online submissions for Combination
    // Sum.
    // Memory Usage: 39.3 MB, less than 65.48% of Java online submissions for
    // Combination Sum.
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        int length = nums.length;
        generateResults(list, new LinkedList<Integer>(), nums, length, target, 0);
        return list;
    }

    private static void generateResults(LinkedList<List<Integer>> list, LinkedList<Integer> tempList, int[] nums,
            int length, int remainder, int index) {
        if (remainder < 0)
            return;
        if (remainder == 0) {
            list.addLast(new LinkedList<>(tempList));
        } else {
            for (int i = index; i < length; i++) {
                tempList.addLast(nums[i]);
                generateResults(list, tempList, nums, length, remainder - nums[i], i + 1);
                tempList.removeLast();
            }
        }
    }
}
