package challenges.medium.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(Math.min(height[i], height[j]) * (j-i), result);
            }
        }
        return result;
    }
}
