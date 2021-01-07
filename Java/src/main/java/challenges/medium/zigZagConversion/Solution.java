package challenges.medium.zigZagConversion;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("0123456789", 4));
    }
    // https://leetcode.com/problems/zigzag-conversion/
    // Runtime: 4 ms, faster than 81.95% of Java online submissions for ZigZag
    // Conversion.
    // Memory Usage: 39 MB, less than 94.20% of Java online submissions for ZigZag
    // Conversion.
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            rows[j] = new StringBuilder();
        }
        int currentRow = 0;
        boolean increasing = true;
        for (int i = 0; i < s.length(); i++) {
            if (currentRow == 0)
                increasing = true;
            if (currentRow == numRows - 1)
                increasing = false;
            rows[currentRow].append(s.charAt(i));
            currentRow = (increasing == true) ? currentRow + 1 : currentRow - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}
