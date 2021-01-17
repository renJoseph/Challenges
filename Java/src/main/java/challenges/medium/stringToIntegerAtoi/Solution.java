package challenges.medium.stringToIntegerAtoi;

public class Solution {
    public static void main(String[] args) {
        String s = "  0000000000012345678";
        System.out.println(myAtoi(s));
    }

    // https://leetcode.com/problems/string-to-integer-atoi/
    // Runtime: 2 ms, faster than 61.21% of Java online submissions for String to
    // Integer (atoi).
    // Memory Usage: 38.7 MB, less than 95.91% of Java online submissions for String
    // to Integer (atoi).
    public static int myAtoi(String s) {
        s = s.stripLeading();
        int i = 0, mult = 1, len = s.length();
        for (; i < len; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                mult *= -1;
            } else if (i == 2) {
                return 0;
            } else if (c != '+') {
                break;
            }
        }
        long result = 0;
        for (; i < len; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            } else {
                result = result * 10 + (s.charAt(i) - '0');
            }
            if (result > Integer.MAX_VALUE) {
                return (mult == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return (int) result * mult;
    }
}
