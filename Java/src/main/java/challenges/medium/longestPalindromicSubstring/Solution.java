package challenges.medium.longestPalindromicSubstring;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccccocc"));

    }

    // https://leetcode.com/problems/longest-palindromic-substring/
    // Runtime: 21 ms, faster than 94.28% of Java online submissions for Longest
    // Palindromic Substring.
    // Memory Usage: 38.8 MB, less than 95.11% of Java online submissions for
    // Longest Palindromic Substring.
    public static String longestPalindrome(String s) {
        int start = 0, end = 0, lenS = s.length();
        for (int stringIndex = 0; stringIndex < lenS; stringIndex++) {
            int startIndex = stringIndex, endIndex = stringIndex;
            while (startIndex > 0 && s.charAt(stringIndex) == s.charAt(startIndex - 1)) {
                startIndex--;
            }
            while (startIndex > 0 && endIndex < lenS - 1 && s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
                startIndex--;
                endIndex++;
            }
            if (endIndex - startIndex + 1 > end - start) {
                start = startIndex;
                end = endIndex;
            }
        }
        return s.substring(start, end + 1);
    }
}
