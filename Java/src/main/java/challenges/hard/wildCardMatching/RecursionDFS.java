package challenges.hard.wildCardMatching;

public class RecursionDFS {
    public static void main(String[] args) {
        String str = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", 
        pattern = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(isMatch(str, pattern));
    }

    public static boolean isMatch(String str, String pattern) {
        return compareStrings(str, pattern, 0, 0);
    }

    public static boolean compareStrings(String str, String pattern, int strIndex, int patternIndex) {
        if (str.length() == strIndex) {
            if (pattern.length() == patternIndex) {
                return true;
            } else {
                return handleExcessPatternChars(str, pattern, strIndex, patternIndex);
            }
        }
        if (strIndex >= str.length()) {
            if (str.length() != 0) {
                if (pattern.charAt(patternIndex) == '*') {
                    return handleAsterisk(str, pattern, strIndex, patternIndex);
                } else {
                    return false;
                }
            }
        }
        if (patternIndex >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(patternIndex) == '*') {
            return handleAsterisk(str, pattern, strIndex, patternIndex);
        } else if (pattern.charAt(patternIndex) == '?') {
            return handleQmark(str, pattern, strIndex, patternIndex);
        } else {
            return handleABC(str, pattern, strIndex, patternIndex);
        }
    }

    public static boolean handleAsterisk(String str, String pattern, int strIndex, int patternIndex) {
        while(patternIndex < pattern.length() -1 && pattern.charAt(patternIndex + 1) == '*'){
            patternIndex++;
        }
        if (patternIndex == pattern.length() - 1)
            return true;
        patternIndex++;
        for (; strIndex < str.length(); strIndex++) {
            if (compareStrings(str, pattern, strIndex, patternIndex)) {
                return true;
            }
        }
        return false;
    }

    public static boolean handleQmark(String str, String pattern, int strIndex, int patternIndex) {
        if (strIndex == str.length() - 1 && patternIndex == pattern.length() - 1) {
            return true;
        } else {
            return compareStrings(str, pattern, strIndex + 1, patternIndex + 1);
        }
    }

    public static boolean handleABC(String str, String pattern, int strIndex, int patternIndex) {
        if (str.charAt(strIndex) == pattern.charAt(patternIndex)) {
            if (strIndex == str.length() - 1 && patternIndex == pattern.length() - 1) {
                return true;
            } else {
                return compareStrings(str, pattern, strIndex + 1, patternIndex + 1);
            }
        } else {
            return false;
        }
    }

    public static boolean handleExcessPatternChars(String str, String pattern, int strIndex, int patternIndex) {
        for (; patternIndex < pattern.length(); patternIndex++) {
            if (pattern.charAt(patternIndex) != '*') {
                return false;
            }
        }
        return true;
    }
}