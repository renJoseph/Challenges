package challenges.medium.letterCominationsOfPhoneNumber;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter
    // Combinations of a Phone Number.
    // Memory Usage: 37.4 MB, less than 98.90% of Java online submissions for Letter
    // Combinations of a Phone Number.

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits.length() != 0) {
            StringBuilder sb = new StringBuilder();
            generateResults(result, sb, digits);
        }
        return result;
    }

    public void generateResults(LinkedList<String> result, StringBuilder sb, String digits) {
        if (digits.length() == 0) {
            result.addLast(sb.toString());
            return;
        } else {
            for (char c : getChars(digits.charAt(0))) {
                sb.append(c);
                generateResults(result, sb, digits.substring(1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public char[] getChars(char c) {
        switch (c) {
            case '2':
                return "abc".toCharArray();
            case '3':
                return "def".toCharArray();
            case '4':
                return "hgi".toCharArray();
            case '5':
                return "jkl".toCharArray();
            case '6':
                return "mno".toCharArray();
            case '7':
                return "pqrs".toCharArray();
            case '8':
                return "tuv".toCharArray();
            case '9':
                return "wxyz".toCharArray();
        }
        throw new IllegalArgumentException();
    }
}
