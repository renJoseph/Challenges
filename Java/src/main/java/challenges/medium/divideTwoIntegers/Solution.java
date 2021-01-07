package challenges.medium.divideTwoIntegers;

public class Solution {
    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }

    public static int divide(int dividend, int divisor) {
        boolean negativeResult = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        if(divisor == Integer.MIN_VALUE){
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        boolean isMinIntvalue = false;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            if (divisor == 1)
                return Integer.MIN_VALUE;
            isMinIntvalue = true;
            dividend += Math.abs(divisor);
        }
        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        if (isMinIntvalue) result++;
        return (negativeResult) ? -result : result;
    }
}
