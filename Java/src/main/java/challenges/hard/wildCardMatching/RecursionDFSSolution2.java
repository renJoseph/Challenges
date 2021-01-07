package challenges.hard.wildCardMatching;

public class RecursionDFSSolution2 {
    public static void main(String[] args) {
        String s = "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", p = "b*b*ab**ba*b**b***bba";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return compareChars(s, p, 0, 0);
    }

    public static boolean compareChars(String s, String p, int indexS, int indexP) {
        if (indexS < s.length() && indexP < p.length()) {
            if ((s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                return compareChars(s, p, indexS + 1, indexP + 1);
            } else if (p.charAt(indexP) == '*') {
                if (indexP == p.length() - 1) {
                    return true;
                }
                indexP++;
                for (; indexS < s.length(); indexS++) {
                    if (compareChars(s, p, indexS, indexP)) {
                        return true;
                    }
                }
            }
        } else if (indexS == s.length()) {
            if (indexP == p.length()) {
                return true;
            } else {
                for (; indexP < p.length(); indexP++) {
                    if (p.charAt(indexP) != '*') {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
