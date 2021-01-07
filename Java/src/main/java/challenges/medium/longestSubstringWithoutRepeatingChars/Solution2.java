package challenges.medium.longestSubstringWithoutRepeatingChars;

import java.util.HashMap;

public class Solution2 {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // Runtime: 4 ms, faster than 89.13% of Java online submissions for Longest
    // Substring Without Repeating Characters.
    // Memory Usage: 38.9 MB, less than 91.42% of Java online submissions for
    // Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring(String s) {
        int count = 0, start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (end < s.length()) {
            if (map.get(s.charAt(end)) != null) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            end++;
            count = Math.max(count, end - start);
        }
        return count;
    }
}
