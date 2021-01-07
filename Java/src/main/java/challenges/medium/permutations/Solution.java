package challenges.medium.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        generateResults(results, tempList, nums);
        return results;
    }

    public static void generateResults(List<List<Integer>> results, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])){
                    continue;
                } else {
                    tempList.add(nums[i]);
                    generateResults(results, tempList, nums);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

}
