package challenges.medium.containerWithMostWater;

public class Solution2 {
    // Runtime: 2 ms, faster than 95.64% of Java online submissions for Container
    // With Most Water.
    // Memory Usage: 40.2 MB, less than 94.58% of Java online submissions for
    // Container With Most Water.
    public int maxArea(int[] height) {
        int result = 0, lower = 0, upper = height.length - 1, maxMin = 0;
        while (upper > lower) {
            int l = height[lower], u = height[upper], min = Math.min(l, u);
            if (min > maxMin) {
                maxMin = min;
                result = Math.max(min * (upper - lower), result);
            }
            if (l > u) {
                upper--;
            } else {
                lower++;
            }
        }
        return result;
    }
}
