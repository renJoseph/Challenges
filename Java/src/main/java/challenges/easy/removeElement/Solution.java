package challenges.easy.removeElement;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] ints = new int[] { 1, 4, 3, 4, 4, 1, 7, 4, 8, 9, 4 };
        int i = removeElement(ints, 4);
        System.out.println("Length: " + i + "\n" + Arrays.toString(ints));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
