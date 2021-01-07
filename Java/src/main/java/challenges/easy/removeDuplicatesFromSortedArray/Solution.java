package challenges.easy.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] ints = new int[] { 1, 1, 2, 3, 5, 6, 6, 7, 7, 7, 7, 7, 8, 9, 9 };
        int i = removeDuplicates(ints);
        System.out.println("Length: " + i + "\n" + Arrays.toString(Arrays.copyOfRange(ints, 0, i)));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
