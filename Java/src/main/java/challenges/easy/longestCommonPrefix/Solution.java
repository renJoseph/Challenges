package challenges.easy.longestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    // https://leetcode.com/problems/longest-common-prefix/
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest
    // Common Prefix.
    // Memory Usage: 36.9 MB, less than 91.34% of Java online submissions for
    // Longest Common Prefix.
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minLength = strs[0].length();
        for (String s : strs) {
            minLength = Math.min(s.length(), minLength);
        }
        int stringIndex = 0;
        for (; stringIndex < minLength; stringIndex++) {
            char comparison = strs[0].charAt(stringIndex);
            for (String s : strs) {
                if (s.charAt(stringIndex) != comparison) {
                    return strs[0].substring(0, stringIndex);
                }
            }
        }
        return "";
    }
}
