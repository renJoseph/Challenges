package challenges.easy.reverseInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-52876));
    }

    // https://leetcode.com/problems/reverse-integer/
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse
    // Integer.
    // Memory Usage: 36 MB, less than 82.15% of Java online submissions for Reverse
    // Integer.
    public static int reverse(int x) {
        long i = 0;
        do {
            i = i * 10 + x % 10;
            x /= 10;
        } while (x != 0);
        if (i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) i;
    }
}
