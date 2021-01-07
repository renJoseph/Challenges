package challenges.medium.longestSubstringWithoutRepeatingChars;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }

    // Runtime: 441 ms, faster than 5.02% of Java online submissions for Longest
    // Substring Without Repeating Characters.
    // Memory Usage: 38.4 MB, less than 99.99% of Java online submissions for
    // Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int lenS = s.length();
        if (lenS < 2)
            return lenS;
        for (int i = 0; i < lenS; i++) {
            int thisCount = 0;
            outerloop: for (int j = i; j < lenS; j++) {
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        break outerloop;
                    }
                }
                thisCount++;
            }
            count = Math.max(count, thisCount);
        }
        return count;
    }
}
