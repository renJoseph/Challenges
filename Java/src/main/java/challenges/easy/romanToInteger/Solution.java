package challenges.easy.romanToInteger;

public class Solution {
    public static void main(String[] args) {
        String s = "helloyuuuuu";
        System.out.println(s.indexOf("omu"));
    }

    // Runtime: 3 ms, faster than 99.91% of Java online submissions for Roman to
    // Integer.
    // Memory Usage: 38.7 MB, less than 99.02% of Java online submissions for Roman to Integer.
    public static int romanToInt(String s) {
        int result = 0, previous = convert(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
        int value = convert(s.charAt(i));
        result += value > previous ? value - (2 * previous) : value;
        previous = value;
        }
        return result;
    }

    public static int convert(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        throw new IllegalArgumentException();
    }
}
