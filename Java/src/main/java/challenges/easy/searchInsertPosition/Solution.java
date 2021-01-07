package challenges.easy.searchInsertPosition;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(searchInsert(nums, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        int indexBefore = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                indexBefore = i + 1;
            }
        }
        return indexBefore;
    }
}
