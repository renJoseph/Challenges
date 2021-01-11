package challenges.hard.wildCardMatching;

public class Backtracking {
    public boolean isMatch(String s, String p) {
        int indexS = 0, indexP = 0, backS = -1, backP = -1, lenS = s.length(), lenP = p.length();
        while (indexS < lenS) {
            char charS = s.charAt(indexS);
            if (indexP < lenP && (p.charAt(indexP) == charS || p.charAt(indexP) == '?')) {
                indexS++;
                indexP++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                backP = indexP;
                backS = indexS + 1;
                indexP++;
            } else if (backP != -1) {
                indexP = backP;
                indexS = backS;
            } else {
                return false;
            }
        }
        for (;indexP < lenP;indexP++) {
            if (p.charAt(indexP) != '*') {
                return false;
            }
        }
        return true;
    }
}
