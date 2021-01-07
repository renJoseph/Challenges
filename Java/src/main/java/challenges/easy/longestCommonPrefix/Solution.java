package challenges.easy.longestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        for (int i = 0; i < getMinStringLength(strs); i++) {
            if(commonCharAtIndex(strs, i)){
                result += strs[0].charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

    public static int getMinStringLength(String[] strs) {
        int minLen = 200;
        for (String s : strs) {
            int x = s.length();
            if (x < minLen) {
                minLen = x;
            }
        }
        return minLen;

    }

    public static boolean commonCharAtIndex(String[] strs, int index) {
        if(strs.length == 0) {return false;}
        for(String s: strs){
            if (s.charAt(index) != strs[0].charAt(index)){
                return false;
            }
        }
        return true;
    }
}
