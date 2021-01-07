package challenges.hard.wildCardMatching;

public class DynamicProgrammingSolution {

    public static void main(String[] args) {
        String str = "", pat = "";
        System.out.println(isMatch(str, pat));
    }

    // Runtime: 26 ms, faster than 44.92% of Java online submissions for Wildcard
    // Matching.
    // Memory Usage: 39.5 MB, less than 50.71% of Java online submissions for
    // Wildcard Matching.
    public static boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[s.length()][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }
}
