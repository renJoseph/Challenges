package challenges.medium.multiplyStrings;

public class Solution {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        int[] nums = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int thisIndex = i + j + 1, nextIndex = i + j,
                        sum = ((num1.charAt(i) - '0') * (num2.charAt(j) - '0')) + nums[thisIndex];
                nums[thisIndex] = sum % 10;
                nums[nextIndex] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums)
            if (!(sb.length() == 0 && n == 0))
                sb.append(n);
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
