package challenges.medium.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    // https://leetcode.com/problems/permutations/
    // Runtime: 1 ms, faster than 93.58% of Java online submissions for
    // Permutations.
    // Memory Usage: 39.2 MB, less than 71.03% of Java online submissions for
    // Permutations.
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        generateResults(results, new ArrayList<Integer>(), nums);
        return results;
    }

    public static void generateResults(List<List<Integer>> results, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    continue;
                } else {
                    tempList.add(num);
                    generateResults(results, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
