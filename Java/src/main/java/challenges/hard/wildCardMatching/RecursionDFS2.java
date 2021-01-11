package challenges.hard.wildCardMatching;

public class RecursionDFS2 {
    public static void main(String[] args) {
        String s = "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", p = "b*b*ab**ba*b**b***bba";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        return compareChars(s, p, 0, 0, lenS, lenP);
    }

    public static boolean compareChars(String s, String p, int indexS, int indexP, int lenS, int lenP) {
        if (indexS < lenS && indexP < lenP) {
            if ((s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                return compareChars(s, p, indexS + 1, indexP + 1, lenS, lenP);
            } else if (p.charAt(indexP) == '*') {
                if (indexP == lenP - 1) {
                    return true;
                }
                indexP++;
                for (; indexS < lenS; indexS++) {
                    if (compareChars(s, p, indexS, indexP, lenS, lenP)) {
                        return true;
                    }
                }
            }
        } else if (indexS == lenS) {
            if (indexP == lenP) {
                return true;
            } else {
                for (; indexP < lenP; indexP++) {
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
