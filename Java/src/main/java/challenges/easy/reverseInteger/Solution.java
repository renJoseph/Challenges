package challenges.easy.reverseInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-52876));
    }

    public static int reverse(int x) {
        long i = 0;
        do {
            i = i*10 + x%10;
            x /= 10;
        } while (x != 0);
        if(i >= Integer.MAX_VALUE || i <= Integer.MIN_VALUE){
            return 0;
        }
        return (int)i;
    }
}
