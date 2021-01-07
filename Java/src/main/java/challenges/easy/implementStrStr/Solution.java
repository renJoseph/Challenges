package challenges.easy.implementStrStr;

public class Solution {
    public static void main(String[] args) {
        System.out.println(strStr("whopper", "per"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needleLength - 1) return i;
            }
        }
        return -1;
    }
}
