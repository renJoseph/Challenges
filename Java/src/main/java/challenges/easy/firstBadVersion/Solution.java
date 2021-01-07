package challenges.easy.firstBadVersion;

public class Solution {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));
    }

    public static boolean isBadVersion(int i) {
        boolean[] bools = { false, false, false, false, false, true, true };
        return bools[i - 1];
    }

    public static int firstBadVersion(int n) {
        int lower = 1;
        int upper = n;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (isBadVersion(mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

}
