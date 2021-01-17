package challenges.medium.integerToRoman;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    // https://leetcode.com/problems/integer-to-roman/
    // Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to
    // Roman.
    // Memory Usage: 38.3 MB, less than 84.16% of Java online submissions for
    // Integer to Roman.
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int tenthPower = 0;
        char[][] translations = { { 'I', 'V', 'X' }, { 'X', 'L', 'C' }, { 'C', 'D', 'M' } };
        while (num > 0) {
            if (tenthPower == 3) {
                sb.append("M");
                num--;
                continue;
            }
            int lastDigit = num % 10;
            if (lastDigit < 4) {
                while (lastDigit > 0) {
                    sb.append(translations[tenthPower][0]);
                    lastDigit--;
                }
            } else if (lastDigit == 4) {
                sb.append(translations[tenthPower][1]).append(translations[tenthPower][0]);
            } else if (lastDigit < 9) {
                while (lastDigit > 5) {
                    sb.append(translations[tenthPower][0]);
                    lastDigit--;
                }
                sb.append(translations[tenthPower][1]);
            } else {
                sb.append(translations[tenthPower][2]).append(translations[tenthPower][0]);
            }
            num /= 10;
            tenthPower++;
        }
        return sb.reverse().toString();
    }

    // Slightly more elegant, though less efficient
    // public static String intToRoman(int num) {
    // String M[] = {"", "M", "MM", "MMM"};
    // String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    // String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    // String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    // StringBuilder sb = new StringBuilder();
    // return
    // sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]).toString();
    // }
}
