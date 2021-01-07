package challenges.medium.firstLastPositionOfArrayElement;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 2, 2 };
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int mid = Arrays.binarySearch(nums, 0, nums.length, target);
        if (mid < 0) {
            return new int[] { -1, -1 };
        } else if (nums.length == 1) {
            return new int[] { 0, 0 };
        } else {
            int first = mid;
            int last = mid;
            for (int i = mid - 1; i >= 0; i--) {
                if (nums[i] != target)
                    break;
                first = i;
            }
            for (int j = mid + 1; j < nums.length; j++) {
                if (nums[j] != target)
                    break;
                last = j;
            }
            return new int[] { first, last };
        }
    }
}
