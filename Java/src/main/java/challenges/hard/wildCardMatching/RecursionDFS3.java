package challenges.hard.wildCardMatching;

public class RecursionDFS3 {
    public static void main(String[] args) {
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(isMatch(s, p));
    }

    // Recursion unfit for purpose, long strings/patterns with many * cause stack to
    // overflow. Backtracking optimal
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (s.length() == 0) {
            for (char c : p.toCharArray()) {
                if (c != '*') {
                    return false;
                }
            }
            return true;
        } else if ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')) {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            if (p.length() == 1) {
                return true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
            }
        }
        return false;
    }
}
