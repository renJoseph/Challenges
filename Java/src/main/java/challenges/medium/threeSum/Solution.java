package challenges.medium.threeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0 };
        System.out.println(threeSum(nums));
    }

    // Runtime: 18 ms, faster than 87.18% of Java online submissions for 3Sum.
    // mMemory Usage: 42.7 MB, less than 82.88% of Java online submissions for 3Sum.
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            if (n1 > 0)
                break;
            if (i > 0 && (nums[i] == nums[i - 1]))
                continue;
            int lower = i + 1, upper = nums.length - 1, target = 0 - n1;
            while (upper > lower) {
                // Binary search may be more efficient instead of using Upper
                int l = nums[lower], u = nums[upper], sum = l + u;
                if (sum < target) {
                    for (; nums[lower] == l && upper > lower; lower++) {
                    }
                } else {
                    if (sum == target) {
                        list.add(Arrays.asList(n1, l, u));
                        for (; nums[lower] == l && upper > lower; lower++) {
                        }
                    }
                    for (; nums[upper] == u && upper > lower; upper--) {
                    }
                }
            }
        }
        return list;
    }
}
